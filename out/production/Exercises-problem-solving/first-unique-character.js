const firstUniqChar = (str) => {
    const charCount = new Map(); // Using a Map for efficient character counting
    for (const char of str) {
        console.log((charCount.get(char) || 0) );
        charCount.set(char, (charCount.get(char) || 0) + 1);
    }
    console.log(charCount);

    for (let i = 0; i < str.length; i++) {
        if (charCount.get(str[i]) === 1) {
            return i;
        }
    }
    return -1;
};