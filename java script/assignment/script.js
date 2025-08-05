
    let users;

    // Async function to fetch users
    const fetchUsers = async (event) => {
      try {
        const response = await fetch('https://dummyjson.com/users'); 

        if (!response.ok) {
          console.log("Error fetching users");
          return;
        }

        const data = await response.json();
        users = data.users;

        console.log(users[0]); 
        logUsers(); 

      } catch (error) {
        console.error("Network error:", error); 
      }
    };

    const logUsers = () => {
      console.log("All users:", users);
    };

    const userBtn = document.querySelector(".userBtn");
    userBtn.addEventListener('click', fetchUsers);
