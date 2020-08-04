
var SIZE_MAP = 40;

var MapObject = cc.Class.extend(
    {

        name: null,
        type: null,
        id: null,
        position: null,
        size: null,
        state: false,
        beginTime: null,


        ctor: function() {
            this._super()
        },

        onCreate: function() {

        },

        isSelected: function() {

        },

        stopAction: function() {

        },

        executeImmediately: function() {

        },

        sendMessage: function() {

        },

        getName: function() {
            return this.name;
        },

        getType: function() {
            return this.type;
        },

        getId: function() {
            return this.id;
        },

        getPosition: function() {
            return this.position;
        },

        getSize: function() {
            return this.size;
        },

        getState: function() {
            return this.state;
        },

        getBeginTime: function() {
            return this.beginTime;
        },

        setName: function(name) {
            this.name = name;
        },

        setType: function(type) {
            this.type = type;
        },

        setId: function(id) {
            this.id = id;
        },

        setPosition: function(position) {
            this.position = position;
        },

        setSize: function(size) {
            this.size = size;
        },

        setState: function(state) {
            this.state = state;
        },

        setBeginTime: function(beginTime) {
            this.beginTime = beginTime;
        }

    }
)

MapObject.findPosition = function(map){
    for(var i = 0; i < SIZE_MAP; ++i) {
        if(map.checkOverlap(this))
            return
    }
}