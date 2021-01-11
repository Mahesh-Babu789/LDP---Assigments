var tri = "";

for(var i = 0; i<5; i++){

    for(var t = 0; t<=i; t++){
      tri +="*";
    }
    tri = tri+"\n";
}
console.log(tri);