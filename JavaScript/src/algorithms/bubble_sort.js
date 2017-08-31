/**
 * Created by viurchuk on 8/10/2017.
 */

var BubbleSort = function (dataArray) {
    /**  @param {Array.<Number>}
     *   @type {Object}
     *   @property {Array.<Number>}
     *   @property {Number}
     * **/
    var algorithm = function (dataArray) {
        var sortedArray = dataArray.slice(0); // clone

        var startedTime = new Date().getTime();

        var isChanged = false;

        var i = 0;
        var tmp;
        var arrayLen = sortedArray.length;
        do {
            isChanged = false;
            for (i = arrayLen - 1; i >= 0; i--) {
                if (sortedArray[i] < sortedArray[i-1]) {
                    tmp = sortedArray[i - 1];
                    sortedArray[i - 1] = sortedArray[i];
                    sortedArray[i] = tmp;
                    isChanged = true;
                }
            }
        } while (isChanged);


        var finishTime = new Date().getTime();
        var timeSpent = finishTime - startedTime;

        return {sortedData: sortedArray, timeSpent: timeSpent};
    };

    return {
        /**  @param {Array.<Number>}
         *   @type {Object}
         *   @property {Array.<Number>}
         *   @property {Number}
         * **/
        execute: function (dataArray) {
            return algorithm(dataArray);
        },

        /**
         * @param {Object} dataObject
         * param {Array.<Number>}
         * param {Number} time spent for sorting
         */
        writeResult: function (dataObject) {
            var text = dataObject.timeSpent.toString();
            addTextToElementId(text, ElementIdConst.BubbleSort.SPENT_TIME);
            printArrayToNode(dataObject.sortedData, ElementIdConst.BubbleSort.SORTED_RESULT)
        }

    }
};

