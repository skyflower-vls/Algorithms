/**
 * Created by viurchuk on 8/10/2017.
 */

var SelectionSort = function (dataArray) {
    /**  @param {Array.<Number>}
     *   @type {Object}
     *   @property {Array.<Number>}
     *   @property {Number}
     * **/
    var algorithm = function (dataArray) {
        var sortedArray = dataArray.slice(0); // clone

        var startedTime = new Date().getTime();

        for (var i = 0; i<sortedArray.length; i++) {
            var minValueIndex = i;

            for (var j=minValueIndex; j<sortedArray.length; j++) {
                if (sortedArray[minValueIndex] > sortedArray[j]) {
                    minValueIndex = j;
                }
            }

            if (minValueIndex != i) {
                var tmp = sortedArray[i];
                sortedArray[i] = sortedArray[minValueIndex];
                sortedArray[minValueIndex] = tmp;
            }
        }


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
            addTextToElementId(text, ElementIdConst.SelectionSort.SPENT_TIME);
            printArrayToNode(dataObject.sortedData, ElementIdConst.SelectionSort.SORTED_RESULT)
        }

    }
};

