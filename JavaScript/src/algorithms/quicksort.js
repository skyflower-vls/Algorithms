/**
 * Created by viurchuk on 8/10/2017.
 */

var QuickSort = function (dataArray) {
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
        var j = partition.call(this,dataArray, lowIndex, hiIndex);
        sort.call(this, dataArray, lowIndex, j - 1);
        sort.call(this, dataArray, j + 1, hiIndex);



    };

    var partition = function (dataArray, lowIndex, hiIndex) {
        var i = lowIndex;
        var j = hiIndex + 1;
        var tmp = 0;

        while(true) {
            while (dataArray[++i] < dataArray[lowIndex]) {  //find item on left to swap
                if (i == hiIndex) break;
            }

            while (dataArray[lowIndex] < dataArray[--j]) {  //find item on right to swap
                if (j == lowIndex) break;
            }

            if ( i >= j) {
                // pointers cross
                break;
            }

             tmp = dataArray[i];
            dataArray[i] = dataArray[j];
            dataArray[j] = tmp;
        }

         tmp = dataArray[lowIndex];
        dataArray[lowIndex] = dataArray[j];
        dataArray[j] = tmp;

        return j;
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
            addTextToElementId(text, ElementIdConst.QuickSort.SPENT_TIME);
            emptyNode(ElementIdConst.QuickSort.SORTED_RESULT);
            showNode(ElementIdConst.QuickSort.SORTED_RESULT, IS_NEED_TO_SHOW_RESULTS);
            if (IS_NEED_TO_SHOW_RESULTS) {
                printArrayToNode(dataObject.sortedData, ElementIdConst.QuickSort.SORTED_RESULT)
            }
        }

    }
};

