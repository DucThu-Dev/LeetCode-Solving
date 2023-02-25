fun searchInsert(nums: IntArray, target: Int): Int {
    var i = 0
    while (i <= nums.lastIndex && nums[i] < target) {
        i++
    }

    return i
}

/**
 * Better solution
 */
fun searchInsert1(nums: IntArray, target: Int): Int {
    var low =0
    var heigh = nums.size-1

    while(low <= heigh  ){
        var mid = low +(heigh - low)/2
        if( nums[mid] == target){
            return mid
        }else if(target > nums[mid]){
            low = mid+1
        }else{
            heigh =mid-1
        }
    }
    return low
}