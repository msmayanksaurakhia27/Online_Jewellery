package com.Online_Jewellery.Online_Jewellery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grocerybackend.DAO.CartLineDAO;
import com.grocerybackend.DAO.CategoryDAO;
import com.grocerybackend.DAO.ProductDAO;
import com.grocerybackend.DAO.SupplierDAO;
import com.grocerybackend.DAO.UserDAO;
import com.grocerybackend.model.Cart;
import com.grocerybackend.model.CartLine;
import com.grocerybackend.model.Category;
import com.grocerybackend.model.Product;
import com.grocerybackend.model.Supplier;
import com.grocerybackend.model.User;

@Controller
public class HomeController {

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	Cart cart;
	@Autowired
	CartLine cartLine;
	@Autowired
	CartLineDAO cartLineDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public String home(Model model) {
		model.addAttribute("UserClickedHome", "true");
		return "index";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("UserClickedAbout", "true");
		return "index";
	}

	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("UserClickedContact", "true");
		return "index";
	}

	@RequestMapping("/Jewellery")
	public String jewellery(Model model) {
		model.addAttribute("prodlist", productDAO.getAll());
		model.addAttribute("UserClickedSingle", "true");
		return "index";
	}

	/***************** SUPPLIER ******************/

	@RequestMapping("/supplier")
	public String Supplier(Model model) {
		model.addAttribute("UserClickedSupplier", "true");
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("url", "suppliersave");
		model.addAttribute("suplist", supplierDAO.getAll());

		return "index";
	}

	@RequestMapping("/suppliersave")
	public String suppliersave(@ModelAttribute("supplier") Supplier supplier) {
		supplierDAO.addSupplier(supplier);
		return "redirect:/supplier";
	}

	@RequestMapping("/editSupplier/{pid}")
	public String supEditCall(@PathVariable("pid") int pid, Model model) {
		model.addAttribute("UserClickedSupplier", "true");
		model.addAttribute("url", "supplierupdate");
		model.addAttribute("supplier", supplierDAO.getSingleSupplier(pid));
		model.addAttribute("suplist", supplierDAO.getAll());

		return "index";
	}

	@RequestMapping("/supplierupdate")
	public String supplierupdate(@ModelAttribute("supplier") Supplier supplier) {
		supplierDAO.updateSupplier(supplier);
		return "redirect:/supplier";
	}

	@RequestMapping("/DeleteSupplier/{pid}")
	public String SupDeleteCall(@PathVariable("pid") int pid, Model model) {
		supplierDAO.DeleteSupplier(supplierDAO.getSingleSupplier(pid));

		return "redirect:/supplier*";
	}

	/*********************** END SUPPLIER **************************/

	/*********************** CATEGORY ****************************/

	@RequestMapping("/category")
	public String Category(Model model) {
		model.addAttribute("UserClickedCategory", "true");
		model.addAttribute("category", new Category());
		model.addAttribute("url", "categorysave");
		model.addAttribute("catlist", categoryDAO.getAll());

		return "index";
	}

	@RequestMapping("/categorysave")
	public String categorysave(@ModelAttribute("category") Category category) {
		categoryDAO.addCategory(category);
		return "redirect:/category";
	}

	@RequestMapping("/editCategory/{pid}")
	public String catEditCall(@PathVariable("pid") int pid, Model model) {
		model.addAttribute("UserClickedCategory", "true");
		model.addAttribute("url", "categoryupdate");
		model.addAttribute("category", categoryDAO.getSingleCategory(pid));
		model.addAttribute("catlist", categoryDAO.getAll());

		return "index";
	}

	@RequestMapping("/categoryupdate")
	public String categoryupdate(@ModelAttribute("category") Category category) {
		categoryDAO.updateCategory(category);
		return "redirect:/category";
	}

	@RequestMapping("/DeleteCategory/{pid}")
	public String catDeleteCall(@PathVariable("pid") int pid, Model model) {
		categoryDAO.DeleteCategory(categoryDAO.getSingleCategory(pid));

		return "redirect:/category*";
	}

	/**************************** END CATEGORY **********************/

	/**************************** PRODUCT ****************************/

	@RequestMapping("/product")
	public String Product(Model model) {
		model.addAttribute("UserClickedProduct", "true");
		model.addAttribute("product", new Product());
		model.addAttribute("catlist", categoryDAO.getAll());
		model.addAttribute("supplist", supplierDAO.getAll());
		model.addAttribute("url", "productsave");
		model.addAttribute("prodlist", productDAO.getAll());

		return "index";
	}

	@RequestMapping(value = "/productsave", method = RequestMethod.POST)
	public String productsave(@ModelAttribute("product") Product product, @RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3,
			@RequestParam("file4") MultipartFile file4, HttpServletRequest request) {
		MultipartFile file[] = { file1, file2, file3, file4 };
		if (file1.isEmpty()) {
			FileUtil.uploadNoImage(request, product.getCode());
		} else {
			FileUtil.uploadFile(request, file, product.getCode());
		}

		productDAO.addProduct(product);
		return "redirect:/product";
	}

	@RequestMapping("/editProduct/{sid}")
	public String prodEditCall(@PathVariable("sid") int sid, Model model) {
		model.addAttribute("UserClickedProduct", "true");
		model.addAttribute("url", "productupdate");

		model.addAttribute("catlist", categoryDAO.getAll());
		model.addAttribute("supplist", supplierDAO.getAll());
		model.addAttribute("product", productDAO.getSingleProduct(sid));
		model.addAttribute("prodlist", productDAO.getAll());

		return "index";
	}

	@RequestMapping("/productupdate")
	public String productupdate(@ModelAttribute("product") Product product, @RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3,
			@RequestParam("file4") MultipartFile file4, HttpServletRequest request) {
		MultipartFile file[] = { file1, file2, file3, file4 };
		if (file1.isEmpty()) {
			FileUtil.uploadNoImage(request, product.getCode());
		} else {
			FileUtil.uploadFile(request, file, product.getCode());
		}

		productDAO.updateProduct(product);
		return "redirect:/product";
	}

	@RequestMapping("/DeleteProduct/{sid}")
	public String prodDeleteCall(@PathVariable("sid") int sid, Model model) {
		productDAO.DeleteProduct(productDAO.getSingleProduct(sid));

		return "redirect:/product";
	}

	/************************* END PRODUCT ***************************/

	/************************* USER *********************/

	@RequestMapping("/user")
	public String User(Model model) {
		model.addAttribute("UserClickedUser", "true");
		model.addAttribute("user", new User());
		model.addAttribute("url", "usersave");
		model.addAttribute("userlist", userDAO.getAll());

		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("UserClickedLogin", "true");

		return "index";
	}

	@RequestMapping("/login_success")
	public String loginSucess(HttpSession session) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userDAO.getEmail(email);

		session.setAttribute("user", user);
		session.setAttribute("loggedin", true);
		return "redirect:/";
	}

	@RequestMapping("/usersave")
	public String usersave(@ModelAttribute("user") User user) {

		user.setRole("ROLE_USER");
		user.setEnable(true);

		userDAO.addUser(user);
		cart.setUser(user);
		cartLineDAO.addCart(cart);
		return "redirect:/user";
	}

	@RequestMapping("/editUser/{sid}")
	public String userEditCall(@PathVariable("sid") int sid, Model model) {
		model.addAttribute("UserClickedUser", "true");
		model.addAttribute("url", "userupdate");
		model.addAttribute("user", userDAO.getSingleUser(sid));
		model.addAttribute("userlist", userDAO.getAll());

		return "index";
	}

	@RequestMapping("/userupdate")
	public String userupdate(@ModelAttribute("user") User user) {
		userDAO.updateUser(user);
		return "redirect:/payment";
	}

	@RequestMapping("/DeleteUser/{sid}")
	public String UserDeleteCall(@PathVariable("sid") int sid, Model model) {
		userDAO.DeleteUser(userDAO.getSingleUser(sid));

		return "redirect:/user";
	}

	@RequestMapping("/viewSingle/{sid}")
	public String viewSingle(@PathVariable("sid") int sid, Model model) {

		model.addAttribute("UserClickedSingleProduct", "true");
		model.addAttribute("product", productDAO.getSingleProduct(sid));
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	/********************** END USER **********************/

	/******************* profile **********************/

	@RequestMapping("/profile")
	public String Profile(Model model, HttpSession session) {
		boolean loggedin=(boolean)session.getAttribute("loggedin");
		if(loggedin!=true)
		{
			return "redirect:/login";
		}
		model.addAttribute("user", (User) session.getAttribute("user"));

		session.setAttribute("user", (User) session.getAttribute("user"));
		model.addAttribute("UserClickedProfile", "true");
		return "index";
	}

	/******************* cart **********************/
	@RequestMapping("/addtocart/{productid}")
	public String Add_to_cart(@PathVariable("productid") int productid, @RequestParam("qty") int qty,
			HttpSession session) {
		
		Product product = productDAO.getSingleProduct(productid);
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return "redirect:/login";
		}
		cart = cartLineDAO.getCartByUserId(user.getSid());

		cartLine.setProduct(product);
		cartLine.setAvailable(true);
		cartLine.setBuyingPrice(product.getPrice());
		cartLine.setCartId(cart.getId());
		cartLine.setProductCount(qty);
		cartLine.setTotal(qty * product.getPrice());

		cartLineDAO.add(cartLine);
		List<CartLine> lst = cartLineDAO.listAvailable(cart.getId());
		cart.setCartLines(lst.size());
		cart.setGrandTotal(this.getGrandTotal(lst));
		cartLineDAO.updateCart(cart);

		return "redirect:/cart";

	}

	private int getGrandTotal(List<CartLine> lst) {
		int grandTotal = 0;
		for (CartLine cartLine : lst) {
			grandTotal += cartLine.getTotal();
		}

		return grandTotal;
	}

	@RequestMapping("/cart")
	public String Cart(Model model, HttpSession session) {
		boolean loggedin=(boolean)session.getAttribute("loggedin");
		if(loggedin!=true)
		{
			return "redirect:/login";
		}
		User user = (User) session.getAttribute("user");
		cart = cartLineDAO.getCartByUserId(user.getSid());
		List<CartLine> lst = cartLineDAO.listAvailable(cart.getId());
		model.addAttribute("UserClickedCart", "true");
		model.addAttribute("cart", cart);
		session.setAttribute("GrandTotal", cart.getGrandTotal());
		model.addAttribute("cartLines", lst);
		return "index";
	}

	@RequestMapping("/cart/{cartLineid}/remove")
	public String DeleteCartLine(@PathVariable("cartLineid") int cartLineid, Model model,HttpSession session) {
		boolean loggedin=(boolean)session.getAttribute("loggedin");
		if(loggedin!=true)
		{
			return "redirect:/login";
		}
		cartLineDAO.remove(cartLineDAO.get(cartLineid));
		return "redirect:/cart";
	}
	@RequestMapping("/update/{cartLineid}")
	public String updateCartLine(@PathVariable("cartLineid") int cartLineid,@RequestParam("qty")int quantity, Model model,HttpSession session) {
		boolean loggedin=(boolean)session.getAttribute("loggedin");
		if(loggedin!=true)
		{
			return "redirect:/login";
		}
		CartLine cartline=cartLineDAO.get(cartLineid);
		cartline.setProductCount(quantity);
		cartline.setTotal(quantity*cartline.getProduct().getPrice());
		cartLineDAO.update(cartline);
		return "redirect:/cart";
	}
	
	@RequestMapping("/payment")
	public String Payment(Model model,HttpSession session) {
		boolean loggedin=(boolean)session.getAttribute("loggedin");
		if(loggedin!=true)
		{
			return "redirect:/login";
		}
		model.addAttribute("UserClickedPayment", "true");
		return "index";
	}

	@RequestMapping("/bill")
	public String bill(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		cart = cartLineDAO.getCartByUserId(user.getSid());
		List<CartLine> lst = cartLineDAO.listAvailable(cart.getId());
		model.addAttribute("UserClickedBill", "true");
		model.addAttribute("cart", cart);
		model.addAttribute("cartLines", lst);
		return "index";
	}
	@RequestMapping("/search")
	public String search(@RequestParam("s")String keyword,Model model) {
		List<Product> prodList=productDAO.searchBykeyword(keyword);
		model.addAttribute("prodlist", prodList);
		model.addAttribute("UserClickedSingle", "true");
		return "index";
	
	
	}
	
	
	@RequestMapping("category/{catid}/products")
	public String search(@PathVariable("catid")int catid,Model model) {
		List<Product> prodList=productDAO.productListByCatId(catid);
		model.addAttribute("prodlist", prodList);
		model.addAttribute("UserClickedSingle", "true");
		return "index";
	
	
	}
}