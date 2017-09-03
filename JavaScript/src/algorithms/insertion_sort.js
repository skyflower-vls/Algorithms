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
        var key;

        for (i = 1; i < arrayLen; i++) {
            key = sortedArray[i];       // second element
            j = i - 1;              // previous element

            while (j >= 0 && key < sortedArray[j]) {
                sortedArray[j + 1] = sortedArray[j]; // second = first
                j = j - 1;                          // next element
            }

            sortedArray[j + 1] = key;  // j = -1  first = second, if while == false -> current_element = current_element
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
            showNode(ElementIdConst.InsertionSort.SORTED_RESULT, IS_NNED_TO_SHOW_RESULTS);
            if (IS_NNED_TO_SHOW_RESULTS) {
                printArrayToNode(dataObject.sortedData, ElementIdConst.InsertionSort.SORTED_RESULT)
            }
        }
    }
};

