let answer = prompt('You owe me $10. Please enter the amount you are paying');

function cashier(amount) {
    let cost = 10;
    let newCost
    newCost = cost - amount;
    return newCost;
}

cashier(answer);

if(cashier(answer) == 0) {
    console.log("You gave the exact amount");
} else if(cashier(answer) < 0) {
    let positiveValue = cashier(answer) * -1;
    console.log("You gave too much. Your change due is $" + positiveValue);
} else if(cashier(answer) > 0) {
    console.log("You gave too little. You still owe $" + cashier(answer));
}