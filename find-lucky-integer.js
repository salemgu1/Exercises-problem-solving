const findLucky = (arr)=> {
    let luckyNumbers = new Set()
    for (let i = 0; i < arr.length; i++) {
        if(countDigits(arr,arr[i])==true){
            luckyNumbers.add(arr[i])
        }
        
    }
    if(largestLucky(luckyNumbers)!=0){
        return largestLucky(luckyNumbers)
    }else{
        return -1
    }
 
};
const countDigits = (arr,number)=>{
    let count = 0
    for(let i=0;i<arr.length;i++){
        if(arr[i]==number){
            count++
        }
    }
    return count==number
}
const largestLucky = (luckyNumbers)=>{
    let maxLuckyNumber = 0
    let luckyNumbersArr= Array.from(luckyNumbers)
    for (let i = 0; i < luckyNumbersArr.length; i++) {
        if(luckyNumbersArr[i]>maxLuckyNumber){
            maxLuckyNumber=luckyNumbersArr[i]
        }
    }
    return maxLuckyNumber
}



