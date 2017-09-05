/**
 * Created by viurchuk on 8/10/2017.
 */

var InsertionSort = function () {
    /**  @param {Array.<Number>}
     *   @type {Object}
     *   @property {Array.<Number>}
     *   @property {Number}
     * **/
    var algorithm = function (dataArray) {
        var sortedArray = dataArray.slice(0); // clone

        var startedTime = new Date().getTime();
        var i, j = 0;
        var arrayLen = sortedArray.length;
        var prevSaveTmp;

        for (i = 0; i < arrayLen; i++) {
            for (j = i; j > 0; j --) {
                if (sortedArray[j] < sortedArray[j-1]) {
                    prevSaveTmp = sortedArray[j-1];
                    sortedArray[j-1] = sortedArray[j]; // prev element = current element
                    sortedArray[j] = prevSaveTmp;
                }
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
            addTextToElementId(text, ElementIdConst.InsertionSort.SPENT_TIME);
            emptyNode(ElementIdConst.InsertionSort.SORTED_RESULT);
            showNode(ElementIdConst.InsertionSort.SORTED_RESULT, IS_NEED_TO_SHOW_RESULTS);
            if (IS_NEED_TO_SHOW_RESULTS) {
                printArrayToNode(dataObject.sortedData, ElementIdConst.InsertionSort.SORTED_RESULT)
            }
        }
    }
};

