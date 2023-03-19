function add_to_cart(pid, pname, price) {
	let cart = localStorage.getItem("cart");
	if (cart == null) {
		let products = [];
		let product = { productId: pid, productName: pname, productQuntity: 1, productPrice: price }
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("product is added first time");
	}
	else {
		let pcart = JSON.parse(cart);
		let oldProduct = pcart.find((item) => item.productId == pid);

		if (oldProduct) {
			
			oldProduct.productQuntity = oldProduct.productId+1
			pcart.map((item) => {
				if(item.productId == oldProduct.productQuntity ){
					item.productQuntity = oldProduct.productQuntity;
				}
			 })
			 localStorage.setItem("cart", JSON.stringify(pcart));
			 console.log("Qauntity is incress");

		} else {
			let product = { productId: pid, productName: pname, productQuntity: 1, productPrice: price }
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("secount product add");
		}
	}
}

