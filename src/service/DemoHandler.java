package service;

import bitzero.server.core.BZEvent;
import bitzero.server.core.BZEventParam;
import bitzero.server.core.BZEventType;
import bitzero.server.core.IBZEvent;
import bitzero.server.entities.User;
import bitzero.server.extensions.BaseClientRequestHandler;
import bitzero.server.extensions.data.DataCmd;

import bitzero.util.ExtensionUtility;
import cmd.CmdDefine;

import cmd.receive.demo.RequestMove;

import cmd.receive.demo.RequestSetName;
import cmd.send.demo.ResponseGetInitGame;
import cmd.send.demo.ResponseGetName;
import cmd.send.demo.ResponseMove;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import cmd.send.demo.ResponseSetName;
import com.google.gson.Gson;
import event.eventType.DemoEventParam;
import event.eventType.DemoEventType;
import extension.FresherExtension;
import model.PlayerInfo;

import modules.game.GameMgr;
import modules.game.data.GameData;
import modules.object.ObjectData;
import modules.object.data.MapObject;
import org.apache.commons.lang.exception.ExceptionUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.server.ServerConstant;

public class DemoHandler extends BaseClientRequestHandler {
    
    public static short DEMO_MULTI_IDS = 2000;
    //FresherExtension fresherExtension = new FresherExtension();
    GameMgr gameMgr = new GameMgr();
    GameData gameData = gameMgr.getGameData();



    /**
     * log4j level
     * ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
     */

    private final Logger logger = LoggerFactory.getLogger("DemoHandler");
    
    public DemoHandler() {
        super();
    }

    /**
     *  this method automatically loaded when run the program
     *  register new event, so the core will dispatch event type to this class
     */
    public void init() {

        getParentExtension().addEventListener(DemoEventType.LOGIN_SUCCESS, this);

    }

    @Override
    /**
     * this method handle all client requests with cmdId in range [1000:2999]
     *
     */
    public void handleClientRequest(User user, DataCmd dataCmd) {

        System.out.println("TEST");
        try {
            switch (dataCmd.getId()) {
                // get username
                case CmdDefine.GET_NAME:
                    processGetName(user);
                    System.out.println("getname");
                    break;
                // set username
                case CmdDefine.SET_NAME:
                    RequestSetName set = new RequestSetName(dataCmd);
                    processSetName(set, user);
                    System.out.println("setname");

                    break;
//                // move
//                case CmdDefine.MOVE:
//                    RequestMove move = new RequestMove(dataCmd);
//                    processMove(user, move);
//                    System.out.println("move");
//
//                    break;
                // send data init game
                case CmdDefine.GET_INIT_GAME:
                    processSendGameInfo(user, dataCmd);
                    System.out.println("initgame");

                    break;


            }

        } catch (Exception e) {
            logger.warn("DEMO HANDLER EXCEPTION " + e.getMessage());
            logger.warn(ExceptionUtils.getStackTrace(e));
        }

    }

    /**
     * events will be dispatch here
     */
    public void handleServerEvent(IBZEvent ibzevent) {        
        if (ibzevent.getType() == DemoEventType.LOGIN_SUCCESS) {
            this.processUserLoginSuccess((User)ibzevent.getParameter(DemoEventParam.USER), (String)ibzevent.getParameter(DemoEventParam.NAME));
        }
    }

    // TO DO

    private void processSendGameInfo(User user, DataCmd dataCmd)
    {
        try {
            gameData.saveModel(user.getId());
            send(new ResponseGetInitGame(gameData), user);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void processMoveObject(User user, RequestMove move) {
        ObjectData object = new ObjectData();
        //object.setPosition(move.getDirection());
    }
    
//    private void processMove(User user, RequestMove move){
//        try {
//            PlayerInfo userInfo = (PlayerInfo) user.getProperty(ServerConstant.PLAYER_INFO);
//            if (userInfo==null){
//                send(new ResponseMove(DemoError.PLAYERINFO_NULL.getValue(), new Point()), user);
//            }
//
//            //userInfo.move(move.getDirection());
//            userInfo.saveModel(user.getId());
//
//            send(new ResponseMove(DemoError.SUCCESS.getValue(), userInfo.position), user);
//
//        } catch (Exception e) {
//            send(new ResponseMove(DemoError.EXCEPTION.getValue(), new Point(0,0)), user);
//        }
//    }
    
    private void processUserLoginSuccess(User user, String name){
        /**
         * process event
         */
        logger.warn("processUserLoginSuccess, name = " + name);
    }

    private void processGetName(User user){
        try{
            PlayerInfo userInfo = (PlayerInfo) user.getProperty(ServerConstant.PLAYER_INFO);
            if (userInfo==null){
                logger.info("PlayerInfo null");
                send(new ResponseGetName(DemoError.PLAYERINFO_NULL.getValue(), ""), user);
            }

            logger.info("get name = " + userInfo.getName());
            send(new ResponseGetName(DemoError.SUCCESS.getValue(), userInfo.getName()), user);
        }catch(Exception e){
            logger.info("processGetName exception");
            send(new ResponseGetName(DemoError.EXCEPTION.getValue(), ""), user);
        }
    }

    private void processSetName(RequestSetName requestSet, User user){
        try{
            PlayerInfo userInfo = (PlayerInfo) user.getProperty(ServerConstant.PLAYER_INFO);
            if (userInfo==null)
                send(new ResponseSetName(DemoError.PLAYERINFO_NULL.getValue(), ""), user);
            String name = userInfo.setName(requestSet.getName());
            send(new ResponseSetName(DemoError.SUCCESS.getValue(), name), user);
            logger.info("set new name = " + name);
            /**
             * dispatch event for another handler
             */
            Map evtParams = new HashMap();
            evtParams.put(DemoEventParam.USER, user);
            evtParams.put(DemoEventParam.NAME, requestSet.getName());
            ExtensionUtility.dispatchEvent(new BZEvent(DemoEventType.CHANGE_NAME, evtParams));
        }catch(Exception e){
            send(new ResponseSetName(DemoError.EXCEPTION.getValue(), ""), user);
        }
    }

    public enum DemoError{
        SUCCESS((short)0),
        ERROR((short)1),
        PLAYERINFO_NULL((short)2),
        EXCEPTION((short)3);
        
        private final short value;
        private DemoError(short value){
            this.value = value;
        }
        
        public short getValue(){
            return this.value;
        }
    }
}
