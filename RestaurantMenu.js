var restaurantMenu = {
    name: "Dosa",
    items : [
        {
            itemName: "Plain Dosa",
            itemPrice: 20
        },
        {
            itemName: "Masala Dosa",
            itemPrice: 30
        },
        {
            itemName: "Upma Dosa",
            itemPrice: 30
        },
        {
            itemName: "Pesara Dosa",
            itemPrice: 30
        },
        {
            itemName: "Onion Dosa",
            itemPrice: 40
        }
    ],
    menuItemsList : function() {
        var menuList = '';
        for(let i = 0; i <= 4; i++) {

            menuList += this.items[i].itemName + ' - $' + this.items[i].itemPrice + "\n";
        }
        alert(menuList);

        var answer = prompt("Which item would you like to order. Enter the item number");
        this.selectItem(answer);
    },
    selectItem : function(number) {
        alert(this.items[number].itemName);
    }
}