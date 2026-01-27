const defangIPaddr = (address) => {
    let obj = {}
    let ip = ""
    for (let i = 0; i < address.length; i++) {
        if (address[i]==='.') {
            obj[i] = "[.]"
        }else obj[i] = address[i]        
    }
    for (const key in obj) {
        if (Object.hasOwnProperty.call(obj, key)) {
            ip+=obj[key];
            
        }
    }
    return ip
}

console.log(defangIPaddr("1.1.1.1"));