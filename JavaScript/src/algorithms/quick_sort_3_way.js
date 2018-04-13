/**
 * Created by viurchuk on 8/10/2017.
 */

var QuickSort3Way = function (dataArray) {
    /**  @param {Array.<Number>}
     *   @type {Object}
     *   @property {Array.<Number>}
     *   @property {Number}
     * **/
    var algorithm = function (dataArray) {
        var sortedArray = dataArray.slice(0); // clone

        var startedTime = new Date().getTime();

        sort.call(this, sortedArray, 0, sortedArray.length -  1);

        var finishTime = new Date().getTime();
        var timeSpent = finishTime - startedTime;

        return {sortedData: sortedArray, timeSpent: timeSpent};
    };

    var sort = function (dataArray, lowIndex, hiIndex) {
        if (hiIndex <= lowIndex) {
            return;
        }
        var lowIt = lowIndex;
        var greatIt = hiIndex;
        var i = lowIndex;
        var compareTo = dataArray[lowIndex];
        var tmp;
        while (i <= greatIt) {
            if (dataArray[i] < compareTo) {
                tmp = dataArray[lowIt];
                dataArray[lowIt] = dataArray[i];
                dataArray[i] = tmp;
                i++;
                lowIt++;
            } else if (dataArray[i] > compareTo) {
                tmp = dataArray[greatIt];
                dataArray[greatIt] = dataArray[i];
                dataArray[i] = tmp;
                greatIt--;
            } else {
                i++;
            }
        }
        
        sort.call(this, dataArray, lowIndex, lowIt - 1);
        sort.call(this, dataArray, greatIt + 1, hiIndex);
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
            addTextToElementId(text, ElementIdConst.QuickSort3Way.SPENT_TIME);
            emptyNode(ElementIdConst.QuickSort3Way.SORTED_RESULT);
            showNode(ElementIdConst.QuickSort3Way.SORTED_RESULT, IS_NEED_TO_SHOW_RESULTS);
            if (IS_NEED_TO_SHOW_RESULTS) {
                printArrayToNode(dataObject.sortedData, ElementIdConst.QuickSort3Way.SORTED_RESULT)
            }
        }

    }
};

