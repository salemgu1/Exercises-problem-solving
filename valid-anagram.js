const isAnagram = (s, t) => {
    if (s.length != t.length) {
        return false;
    }
    let sObj = new Map()
    let tObj = new Map()
    for (let i = 0; i < s.length; i++) {
        sObj.set(s[i], (sObj.get(s[i]) || 0) + 1);
        tObj.set(t[i], (tObj.get(t[i]) || 0) + 1);
    }
    for (let i = 0; i < s.length; i++) {
        if(sObj.get(s[i])==undefined || tObj.get(s[i])==undefined){
            return false
        }
        if(sObj.get(s[i])!=tObj.get(s[i]))
            return false
    }
    return true
  };

console.log(isAnagram("anagram","nagaram"));
