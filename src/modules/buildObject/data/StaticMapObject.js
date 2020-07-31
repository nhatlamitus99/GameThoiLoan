
var StaticMapObject = MapObject.extend(
    {
        value: 0,
        imagePath: null,
        cost: 0,
        removedTime: 0,

        ctor: function() {
            this.getBeginTime()
        },

        create: function() {

        },

        remove: function() {

        },

        getValue: function() {
            return this.value;
        },

        getImage: function() {
            return this.imagePath;
        },

        getCost: function() {
            return this.cost;
        },

        getRemovedTime: function() {
            return this.removedTime;
        },

        setValue: function(value) {
            this.value = value;
        },

        setImage: function(imagePath) {
            this.imagePath = imagePath;
        },

        setCost: function(cost) {
            this.cost = cost;
        },

        setRemovedTime: function(time) {
            this.removedTime = time;
        },
    }
)



