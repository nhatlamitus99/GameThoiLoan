
var BUILDING_TYPE = {
    GOLD_MINE: 1,
    ELIXIR_MINE: 2,
}

var ObjectMgr = cc.Class.extend({

    numTypeObject: 11,
    listObject: new Array(),

    ctor: function(){
        this._super()
        for(var i=0; i < this.numTypeObject; ++i) {
            this.listObject[i] = new Array();
        }

    },

    create: function(buildingType) {
        switch(buildingType) {
            case BUILDING_TYPE.GOLD_MINE:
                GoldMine.create();
            case BUILDING_TYPE.ELIXIR_MINE:
                ElixirMine.create();
        }
    },

    addObject: function(object) {
        this.listObject[object.getType()].push(object);
        cc.log(this.addObject[object.getType()]);
    },

    removeObject: function(object) {
        var pos = this.listObject.indexOf(object);
        this.listObject.splice(pos, 1);
    },

    getListObject: function () {
        return this.listObject;
    },

    getObject: function (type, id) {
        for(var i=0; i < this.listObject.length; ++i) {
            if(this.listObject[i].type === type && this.listObject[i].id === id)
                return this.listObject[i];
        }
    },



    sendMessage: function (message) {

    }



})

