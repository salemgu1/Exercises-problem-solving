const percentageLetter = (s,letter) =>{
    let count = 0
    for (let i = 0; i < s.length; i++) {
        if(s[i]==letter)
            count++
    }
    console.log(count / s.length * 100);
    return Math.round(count / s.length * 100)
}

console.log(percentageLetter("sgawtb","s"));


