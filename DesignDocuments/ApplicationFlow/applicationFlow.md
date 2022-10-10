# Application Flow


### User Sign up

1. User chooses sign up on the menu (available on all pages, unless the user 
is signed in already).
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User chooses sign in on the menu (available on all pages, unless the user 
is signed in already).
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View Property

1. Page sends a request to view property servlet along with criteria 
(all, address, price, name, etc).
1. Servlet uses the properties dao to select reports according to criteria
1. Dao performs select and creates report objects from results.
1. Dao returns list of properties matching criteria to servlet.
1. Servlet sends list back to properties jsp.
1. Properties jsp displays the properties.
1. Consider paging results so page does not get super long and too much data 
is sent.

### About

1. Static page

### Add Property
1. Option only available to logged in users with proper role
1. User enters property  details
1. Details are sent to Add Property  servlet
1. Servlet creates property object
1. Servlet sends object to dao
1. Dao adds property to the database
1. Servlet sends confirmation to property page that property has been added.








 
