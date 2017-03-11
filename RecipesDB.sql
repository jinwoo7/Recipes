# ---------------------------------------------------------------------------------------------------------------------
# SQL Script to Create and Populate the Recipe Table in the Recipes Database (RecipesDB)
# Created by Osman Balci
# ---------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS Recipe;

/* The Recipe table contains attributes of interest of a recipe. */
CREATE TABLE Recipe
(
 	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	image_url VARCHAR(255) NOT NULL,
	source_name VARCHAR(128) NOT NULL,
	source_url VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
);

/*
If a value in INSERT INTO has a single quote, the entire value must be enclosed under plain double quotes.
For example, 'Rick's Mango' must be changed to "Rick's Mango". 
Make sure that it is straight plain " and not a curly quote “.
*/

INSERT INTO Recipe (title, image_url, source_name, source_url) VALUES
('Cool Pineapple And Kiwi Dessert', 'https://www.edamam.com/web-img/ef5/ef58e9ba1ba3021bf871e7faf933370d.jpg', 'Food and Wine', 'http://www.foodandwine.com/recipes/cool-pineapple-and-kiwi-dessert'),
('Garlic Beef', 'https://www.edamam.com/web-img/c22/c2267aabe6cc5dfac892c2549c441d99.jpg', 'BBC Good Food', 'http://www.bbcgoodfood.com/recipes/5535/garlic-beef'),
('Kale, Apple and Pancetta Salad', 'https://www.edamam.com/web-img/607/60791786bb0cf1de65f8d0398be9969c.jpg', 'Serious Eats', 'http://www.seriouseats.com/recipes/2012/02/serious-salads-kale-apple-and-pancetta-salad.html'),
('Fish With Peas & Lettuce', 'https://www.edamam.com/web-img/31f/31f84211721b4c6bcf2d4d3556c28d88.jpg', 'BBC Good Food', 'http://www.bbcgoodfood.com/recipes/2906/fish-with-peas-and-lettuce'),
('Mediterranean Lasagna', 'https://www.edamam.com/web-img/519/519ae7630b70f95f5d06fc5a17a05b44.jpg', 'Cookstr', 'http://www.cookstr.com/Italian-Recipes/Mediterranean-Lasagna'),
('Dessert Wine Gelees with Citrus Fruit', 'https://www.edamam.com/web-img/27e/27eb2938078d74cf8abc3d164c0a3767.jpg', 'Martha Stewart', 'http://www.marthastewart.com/333079/dessert-wine-gelees-with-citrus-fruit'),
('Lasagna', 'https://www.edamam.com/web-img/eb0/eb023dfa0939aa0679c10f345aeda577.jpg', 'Martha Stewart', 'http://www.marthastewart.com/343399/lasagna'),
("The Nasty Bits: Pig's Ear Pizza", 'https://www.edamam.com/web-img/fae/fae7ac099c3da3ef9fa4d8bbeb448e9e.jpg', 'Serious Eats', 'http://www.seriouseats.com/recipes/2010/07/the-nasty-bits-pigs-ear-pizza-recipe.html'),
('Grilled Lamb Kebab Salad with Cucumber, Tomatoes and Pita', 'https://www.edamam.com/web-img/53f/53f8106f503de9742b9bd621ba923ddf.jpg', 'Fine Cooking', 'http://www.finecooking.com/recipes/grilled-lamb-kebab-salad-cucumber-tomatoes-pita.aspx'),
('Herbes de Provence Rotisserie Chickens', 'https://www.edamam.com/web-img/18d/18dcf05995cb40e8ce4c077972341d7a.jpg', 'Bon Appetit', 'http://www.bonappetit.com/recipe/herbes-de-provence-rotisserie-chickens'),
("Rick's Mango, Jicama, and Cucumber Salads", 'https://www.edamam.com/web-img/3fe/3fe43c052f0425849211ce583ffbd77e.jpg', 'Martha Stewart', 'http://www.marthastewart.com/318354/ricks-mango-jicama-and-cucumber-salads'),
('Mustard-Crusted Roast Chickens', 'https://www.edamam.com/web-img/e5e/e5e970a474f571622f5f2eb233a801b0.jpg', 'Fine Cooking', 'http://www.finecooking.com/recipes/mustard-crusted-roast-chickens.aspx'),
('Japanese Style Beef Curry Toast Tapas', 'https://www.edamam.com/web-img/d29/d29e279f78f793edf0397098ffa0a7fb.jpg', 'Honest Cooking', 'http://honestcooking.com/japanese-style-beef-curry-toast/'),
('Caramelized Parmesan Brussels Sprouts', 'https://www.edamam.com/web-img/043/04305c042326657a5a9143c77050e26d.jpg', 'Food52', 'https://food52.com/recipes/1251-caramelized-parmesan-brussels-sprouts'),
('Beef Brisket', 'https://www.edamam.com/web-img/f1d/f1d50c3817e14cfcaf2ec11d4ee65d95.jpg', 'Simply Recipes', 'http://www.simplyrecipes.com/recipes/beef_brisket/'),
('Steamed Fish And Egg Rolls', 'https://www.edamam.com/web-img/029/029097a8f2518891169948caa6b2aaf6.jpg', 'Chubby Hubby', 'http://chubbyhubby.net/recipes/not-your-usual-egg-rolls/'),
('Spagetti Sauce with Meatballs', 'https://www.edamam.com/web-img/fb3/fb3e1f4709cf589859b3eb63e46a1748.jpg', 'BigOven', 'http://www.bigoven.com/recipe/Spagetti-Sauce-with-Meatballs/60831'),
('Island Mango Salad', 'https://www.edamam.com/web-img/373/37361d2ca2895394b4b4ad86ca69bd72.jpg', 'Comida Kraft', 'http://www.comidakraft.com/sp/recetas/ensalada-islena-de-mango-64123.aspx'),
('Lemony Zucchini Goat Cheese Pizza', 'https://www.edamam.com/web-img/a35/a359f8fa1791cbf609f935a906cc0e3a.jpg', 'Smitten Kitchen', 'https://smittenkitchen.com/2009/07/lemony-zucchini-goat-cheese-pizza/'),
('Grilled Steak', 'https://www.edamam.com/web-img/1ea/1ea2779bd0986b7765b561f896be3cc2.jpg', 'Epicurious', 'http://www.epicurious.com/recipes/food/views/Grilled-Steak-102080'),
('Minted English Pea Soup with Lobster and Orange', 'https://www.edamam.com/web-img/d9e/d9ee40a5cba63e3c00cce8280e08ca92.jpg', 'Martha Stewart', 'http://www.marthastewart.com/356649/minted-english-pea-soup-lobster-and-orange'),
('Coffee-Coconut Agar Dessert', 'https://www.edamam.com/web-img/20e/20e15348568a6d14bbceaa351aa871e2.jpg', 'Serious Eats', 'http://www.seriouseats.com/recipes/2012/08/coffee-coconut-agar-dessert.html'),
('Hoisin-Glazed Eggplant', 'https://www.edamam.com/web-img/6e1/6e1ac7de72e4a58ce81d39382e0a1dd3.jpg', 'Martha Stewart', 'http://www.marthastewart.com/317065/hoisin-glazed-eggplant'),
('Tangy Tomato Chutney', 'https://www.edamam.com/web-img/de4/de4b73f4145ca9fb3676f6bf906b7609.jpg', 'BBC Good Food', 'http://www.bbcgoodfood.com/recipes/1582/tangy-tomato-chutney-'),
('Pizza Bianca with Prosciutto, Arugula, and Parmesan', 'https://www.edamam.com/web-img/542/5423238ac31ce71820c6108cbc3cd54d.jpg', 'Bon Appetit', 'http://www.bonappetit.com/recipe/pizza-bianca-with-prosciutto-arugula-and-parmesan'),
('Triple-Pepper T-Bone Steaks', 'https://www.edamam.com/web-img/978/9786dfa24b198b2acc41ed7fcb5dd8e9.jpg', 'Bon Appetit', 'http://www.bonappetit.com/recipe/triple-pepper-t-bone-steaks'),
('Poached Egg On Potato Hash', 'https://www.edamam.com/web-img/d67/d676fa12e7ac2afd6530404b62aa550b.jpg', 'Tartelette', 'http://www.tarteletteblog.com/2013/05/gluten-free-recipe-jerusalem-artichoke.html'),
('Minced Beef Chappli Kebabs', 'https://www.edamam.com/web-img/ffd/ffd475a01b344b9a500af507f3f77c38.jpg', 'BBC', 'http://www.bbc.co.uk/food/recipes/mincedbeefchapplikeb_90228'),
('Fish Tacos', 'https://www.edamam.com/web-img/125/125615ded1b7371ad9504295abae3a68.jpg', 'Simply Recipes', 'http://www.simplyrecipes.com/recipes/fish_tacos/'),
('Grilled Whole Fish On Banana Leaf', 'https://www.edamam.com/web-img/00e/00e8a72b61b3ff5f1fb39d3581235673.jpg', 'Steamy Kitchen', 'http://steamykitchen.com/190-wholefishbanana.html'),
('Classic Baked Chicken', 'https://www.edamam.com/web-img/6fd/6fd818eb6587372f9c186518d42db8c7.jpg', 'Simply Recipes', 'http://www.simplyrecipes.com/recipes/classic_baked_chicken/'),
('Grilled Lemons, Baby Artichokes, and Eggplant', 'https://www.edamam.com/web-img/001/00127cd3e04a4b99d838f62a6755061c.jpg', 'Bon Appetit', 'http://www.bonappetit.com/recipe/grilled-lemons-baby-artichokes-and-eggplant'),
('Tomato Marmalade', 'https://www.edamam.com/web-img/ab1/ab1dbb063af01a88735e3348e80083ed.jpg', 'Martha Stewart', 'http://www.marthastewart.com/315286/tomato-marmalade'),
('Beef Goulash', 'https://www.edamam.com/web-img/229/2292adfebf71a994fc515cd5895012fe.jpg', 'Martha Stewart', 'http://www.marthastewart.com/350032/beef-goulash'),
('Egg Nests', 'https://www.edamam.com/web-img/af9/af9d579ef6c658ef398d2bc76690ce7e.jpg', 'Simply Recipes', 'http://www.simplyrecipes.com/recipes/egg_nests/'),
('Broiled Fillet Steak with Green Pepper and Brandy Sauce', 'https://www.edamam.com/web-img/638/638a988cd595e222bebed41f451cf9dc.jpg', 'Food52', 'https://food52.com/recipes/2048-broiled-fillet-steak-with-green-pepper-and-brandy-sauce'),
('Dessert Sushi', 'https://www.edamam.com/web-img/197/197734f47bc39408056a3e23c4a91073.jpg', 'Food52', 'https://food52.com/recipes/11405-dessert-sushi'),
('Grilled Eggplant Parmigiana', 'https://www.edamam.com/web-img/f6c/f6cde666e031591986942094060f8d5b.jpg', 'Epicurious', 'http://www.epicurious.com/recipes/food/views/Grilled-Eggplant-Parmigiana-238668'),
('Heirloom Tomato Salad with Bocconcini and Basil', 'https://www.edamam.com/web-img/460/460d8667f0adeffe3fd1b57739b860ee.jpg', 'Food and Style', 'http://foodandstyle.com/heirloom-tomato-salad-with-bocconcini-and-basil/'),
('Dessert Pancakes with Custard and Berries', 'https://www.edamam.com/web-img/73f/73f5d260147b5df4e4ecb8916caf670e.jpg', 'Epicurious', 'http://www.epicurious.com/recipes/food/views/Dessert-Pancakes-with-Custard-and-Berries-358551'),
('Perfect Grilled Fish Steaks', 'https://www.edamam.com/web-img/9be/9be37985e53b2158a974437a959a9e2d.jpg', 'NY Magazine', 'http://nymag.com/restaurants/articles/recipes/fishsteak.htm'),
('Roasted Vegetable and Prosciutto Lasagna with Alfredo Sauce', 'https://www.edamam.com/web-img/41f/41f0df79b53d2b28c74bd742a9dbcf10.jpg', 'Epicurious', 'http://www.epicurious.com/recipes/food/views/Roasted-Vegetable-and-Prosciutto-Lasagna-with-Alfredo-Sauce-104591'),
('Shish Kebab', 'https://www.edamam.com/web-img/b8e/b8e2162316b3ee442b4cefd5339ceac4.jpg', 'Saveur', 'http://www.saveur.com/article/Recipes/Shish-Kebab'),
('Chorizo and Roasted Pepper Pizza', 'https://www.edamam.com/web-img/94e/94e45126f8b58ffcfd8188bfd7b3e642.jpg', 'Real Simple', 'http://www.realsimple.com/food-recipes/browse-all-recipes/chorizo-roasted-pepper-pizza'),
('Stewed Beef Neck Tacos', 'https://www.edamam.com/web-img/076/07637ea2e5331eac05e16ae5ae122db9.jpg', 'Serious Eats', 'http://www.seriouseats.com/recipes/2011/08/stewed-beef-neck-tacos-recipe.html'),
('Fresh Pear and Almond Dessert Pizza', 'https://www.edamam.com/web-img/916/916ae09b4ddcff86b93a484aa64a3974.jpg', 'San Francisco Gate', 'http://www.sfgate.com/food/recipes/detail/?rid=16151&sorig=qs'),
('Marinated Eggplant With Capers And Mint', 'https://www.edamam.com/web-img/1fe/1fe26c96f8ad7eef400a3d3bc9561643.jpg', 'Smitten Kitchen', 'https://smittenkitchen.com/2008/08/marinated-eggplant-with-capers-and-mint/'),
('Vegetable Lasagna', 'https://www.edamam.com/web-img/b63/b6365c6139c7be4c208f78e05cf58802.jpg', 'Self', 'http://www.self.com/food/recipes/2005/09/vegetable-lasagna'),
('Fish with Mango Relish', 'https://www.edamam.com/web-img/126/1264f82898cec0b745be060654425945.jpg', 'Martha Stewart', 'http://www.marthastewart.com/340934/fish-with-mango-relish'),
('Super-Simple Apple-Cinnamon Dessert Crepes', 'https://www.edamam.com/web-img/06e/06e734307dfb0264dfc9477edf42dd07.jpg', 'Cooking Channel', 'http://www.cookingchanneltv.com/recipes/lisa-lillien/super-simple-apple-cinnamon-dessert-crepes.html');
