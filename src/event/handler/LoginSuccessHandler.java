package event.handler;

import bitzero.server.core.BZEvent;
import bitzero.server.core.BZEventParam;
import bitzero.server.core.BZEventType;
import bitzero.server.core.IBZEvent;
import bitzero.server.entities.User;
import bitzero.server.extensions.BaseServerEventHandler;
import bitzero.server.extensions.ExtensionLogLevel;

import bitzero.util.ExtensionUtility;

import java.util.HashMap;
import java.util.Map;

import event.eventType.DemoEventParam;
import event.eventType.DemoEventType;
import model.PlayerInfo;
import util.server.ServerConstant;

public class LoginSuccessHandler extends BaseServerEventHandler {
    public LoginSuccessHandler() {
        super();
    }

    public void handleServerEvent(IBZEvent iBZEvent) {
        this.onLoginSuccess((User) iBZEvent.getParameter(BZEventParam.USER));
    }

    /**
     * @param user
     * description: after login successful to server, core framework will dispatch this event
     */
    private void onLoginSuccess(User user) {
        trace(ExtensionLogLevel.DEBUG, "On Login Success ", user.getName());
        PlayerInfo pInfo = null;
        try {
            pInfo = (PlayerInfo) PlayerInfo.getModel(user.getId(), PlayerInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (pInfo==null){
            pInfo = new PlayerInfo(user.getId(), user.getName());
            try {
                user.setName("newAccount_" + user.getId());
                pInfo.saveModel(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            user.setName("existedAccount_" + user.getId());
        }
        /**
         * cache playerinfo in RAM
         */
        user.setProperty(ServerConstant.PLAYER_INFO, pInfo);

        /**
         * send login success to client
         * after receive this message, client begin to send game logic packet to server
         */
        ExtensionUtility.instance().sendLoginOK(user);
        
        /**
         * dispatch event here
         */
        Map evtParams = new HashMap();
        evtParams.put(DemoEventParam.USER, user);
        evtParams.put(DemoEventParam.NAME, user.getName());
        ExtensionUtility.dispatchEvent(new BZEvent(DemoEventType.LOGIN_SUCCESS, evtParams));

    }

}
