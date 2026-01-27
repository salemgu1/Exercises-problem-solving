const isPalindrome = (head) => {
    let current = head
    let arr = []
    while(current){
        arr.push(current.value)
        current = current.next
    }

    let start = 0
    let end = arr.length -1

    while(start<end){
        if(arr[start]!=arr[end]){
            return false
        }
        start++
        end--
    }
    return true
    
}