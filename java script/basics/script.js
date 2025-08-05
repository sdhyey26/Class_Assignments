
// function addition(){
// let number1 = 10;
// let number2 = 20;
// console.log(number1 + number2 + " hey");
// }

// addition();

// var arr = [0 , 1 , 2]
// var name = "Dhyey"
// console.log(name.length); 
// console.log(name.toUpperCase()); 
// console.log(name.toLowerCase()); 
// console.log(name.charAt(2)); 
// console.log(name.indexOf('y')); 
// console.log(name.slice(1, 4)); 
// console.log(name.replace('D', 'B')); 
// console.log(name.includes('hey')); 

// players = ['Dhyey', 'Aman', 'Rohan', 'Sahil'];
// players.push('Karan');
// players.pop();
// players.unshift('Raj');
// players.shift();
// players.splice(1, 2, 'Nikhil', 'Suresh');
// players.sort();
// players.reverse();
// players.slice(1, 3);
// console.log(players.length);
// console.log(players);

// let name1 = 'Dhyey';
// name1 = Number(name);

// console.log(name1);

// console.log(greet('Dhyey'));


// function greet(name) {
//     return `Hello, ${name}!`;
// }

// const greet = function(name) {
//     console.log(`Hello, ${name}!`) ;
// }

// greet('Dhyey');

// const products = [100, 250, 75, 50]; 
// const taxRate = 0.18; 

// const total = products
//     .map(price => price + price * taxRate)
//     .reduce((sum, priceWithTax) => sum + priceWithTax, 0);

// console.log(`Total with tax: ${total}`);

// const number = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 18];

// const evenNumbers = number.filter(num => num % 2 === 0);
// const oddNumbers = number.filter(num => num % 2 !== 0);
// const divisibleBy3Not2 = number.filter(num => num % 3 === 0 && num % 2 !== 0);

// console.log('Even numbers:', evenNumbers);
// console.log('Odd numbers:', oddNumbers);
// console.log('Divisible by 3 but not by 2:', divisibleBy3Not2);

// function findDuplicates(arr) {
//   let duplicates = [];
//   let seen = {};

//   for (let i = 0; i < arr.length; i++) {
//     let value = arr[i];

//     if (seen[value]) {
//       if (!duplicates.includes(value)) {
//         duplicates.push(value);
//       }
//     } else {
//       seen[value] = true;
//     }
//   }

//   return duplicates;
// }

// let numbers = [1, 2, 3, 4, 2, 5, 6, 1, 7, 3];
// let result = findDuplicates(numbers);
// console.log("Duplicate elements:", result);

// function removeWhitespaces(str) {
//   return str.replace(/\s+/g, '');
// }

// let input = "a b c d";
// let output = removeWhitespaces(input);
// console.log("Output:", output);

// function areRotations(str1, str2) {
//   if (str1.length !== str2.length) {
//     return false;
//   }

//   let combined = str1 + str1;
//   return combined.includes(str2);
// }

// let str1 = "abcd";
// let str2 = "cdab";
// let result = areRotations(str1, str2);
// console.log("Are rotations:", result);

// const myFunction = (callbackFun) => {
//   callbackFun(5);
// };

// myFunction(function(value) {
//   console.log(value);
// });

// myFunction((value) => {
//   console.log(value * value);
// });

// Create an array of blog objects

// const blogs = [
//     {
//         title: "JavaScript Basics",
//         content: "Learn variables, functions, and loops.",
//         author: "Dhyey",
//         publish: function () {
//             console.log(`"${this.title}" has been published.`);
//         },
//         unpublish: function () {
//             console.log(`"${this.title}" has been unpublished.`);
//         }
//     },
//     {
//         title: "React Guide",
//         content: "Understand components, hooks, and state.",
//         author: "Dhyey",
//         publish: function () {
//             console.log(`"${this.title}" has been published.`);
//         },
//         unpublish: function () {
//             console.log(`"${this.title}" has been unpublished.`);
//         }
//     },
//     {
//         title: "Node.js Crash Course",
//         content: "Build servers with Express and Node.js.",
//         author: "Dhyey",
//         publish: function () {
//             console.log(`"${this.title}" has been published.`);
//         },
//         unpublish: function () {
//             console.log(`"${this.title}" has been unpublished.`);
//         }
//     }
// ];


// function printAllBlogs(blogArray) {
//     console.log("=== All Blogs ===");
//     blogArray.forEach((blog, index) => {
//         console.log(`\nBlog ${index + 1}:`);
//         console.log(`Title: ${blog.title}`);
//         console.log(`Author: ${blog.author}`);
//         console.log(`Published: ${blog.isPublished}`);
//         console.log(`Content: ${blog.content}`);
//     });
// }

// blogs[0].publish();  
// blogs[2].publish();  

// printAllBlogs(blogs); 
  
// function Blog(title, content, author) {
//     this.title = title;
//     this.content = content;
//     this.author = author;
//     this.isPublished = false;

//     this.publish = function () {
//         this.isPublished = true;
//         console.log(`"${this.title}" has been published.`);
//     };

//     this.unpublish = function () {
//         this.isPublished = false;
//         console.log(`"${this.title}" has been unpublished.`);
//     };
// }

// blog1 = new Blog("JavaScript Basics", "Learn variables, functions, and loops.", "Dhyey");


// blogs = [ new Blog("JavaScript Basics", "Learn variables, functions, and loops.", "Dhyey"),
//     new Blog("React Guide", "Understand components, hooks, and state.", "Dhyey"),
// ];

// function printAllBlogs(blogArray) {
//     console.log("=== All Blogs ===");
//     blogArray.forEach((blog, index) => {
//         console.log(`\nBlog ${index + 1}:`);
//         console.log(`Title: ${blog.title}`);
//         console.log(`Author: ${blog.author}`);
//         console.log(`Published: ${blog.isPublished}`);
//         console.log(`Content: ${blog.content}`);
//     });

//    printAllBlogs(blogs);
   
// }

// function Blog(title, content, author) {
//     this.title = title;
//     this.content = content;
//     this.author = author;
//     this.isPublished = false;

//     this.publish = function () {
//         this.isPublished = true;
//         console.log(`"${this.title}" has been published.`);
//     };

//     this.unpublish = function () {
//         this.isPublished = false;
//         console.log(`"${this.title}" has been unpublished.`);
//     };
// }


// const user = {
//     username: "dhyey123",
//     isLoggedIn: false,
//     blogs: [],

//     login: function () {
//         this.isLoggedIn = true;
//         console.log(`${this.username} logged in.`);
//     },

//     logout: () => {
//         user.isLoggedIn = false;
//         console.log(`${user.username} logged out.`);
//     },

//     createBlog: function (title, content , authorname) {
//         if (!this.isLoggedIn) {
//             console.log("Please log in to create a blog.");
//             return;
//         }

//         const blog = new Blog(title, content, authorname);
//         blog.publish(); 
//         this.blogs.push(blog);
//     },

//     unpublishBlog: function (title) {
//         const blog = this.blogs.find(b => b.title === title);
//         if (blog) {
//             blog.unpublish();
//         } else {
//             console.log(`Blog with title "${title}" not found.`);
//         }
//     },

//     listBlogs: function () {
//         if (this.blogs.length === 0) {
//             console.log("No blogs available.");
//             return;
//         }

//         console.log("=== All Blogs ===");
//         this.blogs.forEach((blog, index) => {
//             console.log(`\nBlog ${index + 1}:`);
//             console.log(`Title: ${blog.title}`);
//             console.log(`Author: ${blog.author}`);
//             console.log(`Published: ${blog.isPublished}`);
//             console.log(`Content: ${blog.content}`);
//         });
//     },

//     searchBlogs: function (keyword) {
//         const results = this.blogs.filter(
//             blog =>
//                 blog.title.toLowerCase().includes(keyword.toLowerCase()) ||
//                 blog.content.toLowerCase().includes(keyword.toLowerCase())
//         );

//         if (results.length === 0) {
//             console.log(`No blogs found for keyword "${keyword}".`);
//         } else {
//             console.log(`Found ${results.length} blog(s) for keyword "${keyword}":`);
//             results.forEach((blog, i) => {
//                 console.log(`\nResult ${i + 1}:`);
//                 console.log(`Title: ${blog.title}`);
//                 console.log(`Content: ${blog.content}`);
//             });
//         }
//     },

//     countPublishedBlogs: function () {
//         const count = this.blogs.filter(blog => blog.isPublished).length;
//         console.log(`Total published blogs: ${count}`);
//         return count;
//     }
// };

// user.login(); 
// user.createBlog("JavaScript basics", "Learn variables, functions, and loops." , "Dhyey");
// // user.createBlog("React Guide", "Understand components, hooks, and state.");
// // user.createBlog("Node.js Crash Course", "Build servers with Express and Node.js.");
// user.listBlogs();
// user.searchBlogs("JavaScript Basics");    
// user.countPublishedBlogs(); 
// user.unpublishBlog("React Guide"); 
// // user.listBlogs(); 
// user.logout();

// const players = ['Dhyey', 'Aman', 'Rohan', 'Sahil', 'Karan'];

// function displayPlayers() {
//     const table = document.querySelector('.table');
    
//     players.forEach((player, index) => {
//         const row = document.createElement('tr');
//         row.innerHTML = `<td>${index + 1}</td><td>${player}</td>`;
//         table.appendChild(row);
//     });
// }


// displayPlayers()

// const allP = document.querySelectorAll('p');

// allP.forEach(para => {
//     if (para.textContent.includes('failed')) {
//         para.classList.add('error');
//     }
//     if (para.textContent.includes('success')) {
//         para.classList.add('success');
//     }
// });

const inputField = document.querySelector('.input');
const outputField = document.querySelector('.output');

inputField.addEventListener('input', () = > {
    outputField.value = inputValue.value
    outputField.setAttribute('style', 'color : green'); 
})

