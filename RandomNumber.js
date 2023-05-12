function randNumber(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    
    var number = Math.ceil(Math.random() * (max - min)) + min;
    console.log(number);
}

randNumber(10, 100);