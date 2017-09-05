/**
 * Created by viurchuk on 9/5/2017.
 */

var ShellSort = function () {
    /**  @param {Array.<Number>}
     *   @type {Object}
     *   @property {Array.<Number>}
     *   @property {Number}
     * **/
    var algorithm = function (dataArray) {
        var sortedArray = dataArray.slice(0); // clone
        var arrayLen = sortedArray.length;

        var i, j = 0;
        var prevSaveTmp;

        var h = 1;

        var startedTime = new Date().getTime();

        while (h < arrayLen / 3) {
           h = 3*h + 1;  // 3x +1 incremental sequence
        }

        while (h >= 1) {
            console.log(h);
            for (i = h; i < arrayLen; i++) {   // insertion sort
                for (j = i; j >= h && (sortedArray[j] < sortedArray[j - h]); j -= h) {
                    prevSaveTmp = sortedArray[j- h];
                    sortedArray[j - h] = sortedArray[j];
                    sortedArray[j] = prevSaveTmp; // prev element = current element
                }
            }

            h =  Math.floor(h / 3); // move to next increment
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
            addTextToElementId(text, ElementIdConst.ShellSort.SPENT_TIME);
            emptyNode(ElementIdConst.ShellSort.SORTED_RESULT);
            showNode(ElementIdConst.ShellSort.SORTED_RESULT, IS_NEED_TO_SHOW_RESULTS);
            if (IS_NEED_TO_SHOW_RESULTS) {
                printArrayToNode(dataObject.sortedData, ElementIdConst.ShellSort.SORTED_RESULT)
            }
        }
    }
};

