

var ArmyCamp = CreatedMapObject.extend({
    capacity: 0,
    value: 0,

    ctor: function() {
        this._super();
    },

    getCapacity: function() {
        return this.capacity;
    },

    setCapacity: function(capacity) {
        this.capacity = capacity;
    },

    getValue: function() {
        return this.value;
    },

    setValue: function(value) {
        this.value = value;
    }

})