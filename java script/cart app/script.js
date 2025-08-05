let grandTotal = 0;

function updatePriceDisplay() {
  const productSelect = document.getElementById("product");
  const selectedOption = productSelect.options[productSelect.selectedIndex];
  const price = selectedOption.getAttribute("data-price");
  document.getElementById("price-value").textContent = price;
}

function addToCart() {
  const productSelect = document.getElementById("product");
  const quantitySelect = document.getElementById("quantity");
  const cartBody = document.getElementById("cart-body");

  const selectedOption = productSelect.options[productSelect.selectedIndex];
  const productName = selectedOption.text;
  const price = parseFloat(selectedOption.getAttribute("data-price"));
  const quantity = parseInt(quantitySelect.value);
  const total = price * quantity;
  const date = new Date().toLocaleDateString();

  const row = document.createElement("tr");
  row.innerHTML = `
    <td>${productName}</td>
    <td>${price}</td>
    <td>${quantity}</td>
    <td>${total}</td>
    <td>${date}</td>
  `;
  cartBody.appendChild(row);

  grandTotal += total;
  document.getElementById("grand-total").textContent = grandTotal;
}

window.onload = updatePriceDisplay;
