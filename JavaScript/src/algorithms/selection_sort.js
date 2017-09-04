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
        var i = 0;
        var j = 0;
        var minValueIndex = 0;
        var arrayLen = sortedArray.length;
        var tmp;

        for (i ; i < arrayLen; i++) {
            minValueIndex = i;

            for (j = minValueIndex; j < arrayLen; j++) {
                if (sortedArray[minValueIndex] > sortedArray[j]) {
                    minValueIndex = j;
                }
            }

            if (minValueIndex != i) {
                tmp = sortedArray[i];
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
            emptyNode(ElementIdConst.SelectionSort.SORTED_RESULT);
            showNode(ElementIdConst.SelectionSort.SORTED_RESULT, IS_NEED_TO_SHOW_RESULTS);
            if (IS_NEED_TO_SHOW_RESULTS) {
                printArrayToNode(dataObject.sortedData, ElementIdConst.SelectionSort.SORTED_RESULT)
            }
        }

    }
};

