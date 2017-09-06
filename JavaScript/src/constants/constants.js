/**
 * Created by viurchuk on 8/10/2017.
 */

var MAX_SIZE     = 500;
var MAX_RANGE    = 100;

var IS_NEED_TO_SHOW_RESULTS = false;

var ElementIdConst = {
    InsertionSort : {
        SPENT_TIME      : "spent_time_insertion_sort",
        SORTED_RESULT   : "sorted_result_insertion_sort"
    },
    MergeSort : {
        SPENT_TIME      : "spent_time_merge_sort",
        SORTED_RESULT   : "sorted_result_merge_sort"
    },
    BubbleSort : {
        SPENT_TIME      : "spent_time_bubble_sort",
        SORTED_RESULT   : "sorted_result_bubble_sort"
    },
    SelectionSort : {
        SPENT_TIME      : "spent_time_selection_sort",
        SORTED_RESULT   : "sorted_result_selection_sort"
    },
    ShellSort : {
        SPENT_TIME      : "spent_time_shell_sort",
        SORTED_RESULT   : "sorted_result_shell_sort"
    },
    QuickSort : {
        SPENT_TIME      : "spent_time_quick_sort",
        SORTED_RESULT   : "sorted_result_quick_sort"
    }
};
