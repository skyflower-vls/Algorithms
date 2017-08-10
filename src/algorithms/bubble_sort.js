/**
 * Created by viurchuk on 8/10/2017.
 */

var BubbleSort = function () {
    return {
        /**  @param {Array.<Number>}
         *   @type {Object}
         *   @property {Array.<Number>}
         *   @property {Number}
         * **/
        execute: function (dataArray) {
            var sortedArray = dataArray.slice(0); // clone

            var startedTime = new Date().getTime();

            var isChanged = false;

            do {
                isChanged = false;
                for (var i = sortedArray.length - 1; i >= 0; i--) {
                    if (sortedArray[i] < sortedArray[i-1]) {
                        var tmp = sortedArray[i - 1];
                        sortedArray[i - 1] = sortedArray[i];
                        sortedArray[i] = tmp;
                        isChanged = true;
                    }
                }
            } while (isChanged);


            var finishTime = new Date().getTime();
            var timeSpent = finishTime - startedTime;

            return {sortedData: sortedArray, timeSpent: timeSpent};
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

