package com.example.udriveup.repository;

import com.example.udriveup.models.Category;
import com.example.udriveup.models.Product;
import com.example.udriveup.models.Story;
import com.example.udriveup.models.SubCategory;

import java.util.ArrayList;

public class RemoteDataSource {

    private static RemoteDataSource instance;

    public ArrayList<Category> categoriesList = new ArrayList<>();
    public ArrayList<SubCategory> subCategoriesList = new ArrayList<>();
    public ArrayList<Story> storiesList = new ArrayList<>();
    public ArrayList<Product> productsList = new ArrayList<>();

    private RemoteDataSource(){

       fillData();
    }

    public static RemoteDataSource getInstance(){

        if (instance == null)
            instance = new RemoteDataSource();

        return instance;
    }

    private void fillData(){

        String[] productsImages = {
                "https://images-na.ssl-images-amazon.com/images/I/81Rar%2BBf8WL.jpg",
                "https://st.focusedcollection.com/9163412/i/1800/focused_317507490-stock-photo-fashionable-handsome-man-stylish-gray.jpg",
                "https://images.unsplash.com/photo-1513269890889-8e4e362e5593?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwcm9maWxlLXBhZ2V8M3x8fGVufDB8fHx8&w=1000&q=80",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReqxWBq6X8J208UjrIvuxdUiR9pEjbzJpRfw&usqp=CAU",
                "https://www.next.ae/nxtcms/resource/image/4607748/portrait_ratio4x5/560/700/22f7178776e9b9b7f08f65d21295dc1/185855115F4C25E73FF96950C19F5EBF/mens-suits.jpg",
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/nordstrom-rack-1586291758.jpg?crop=1xw:1xh;center,top&resize=480:*",
                "https://image.menswearhouse.com/is/image/marketing/22-2919285-sport-coats-V2-2x.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/81Rar%2BBf8WL.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReqxWBq6X8J208UjrIvuxdUiR9pEjbzJpRfw&usqp=CAU",
                "https://image.menswearhouse.com/is/image/marketing/22-2919285-sport-coats-V2-2x.jpg",
        };

        String[] storiesImages = {
                "https://lumiere-a.akamaihd.net/v1/images/ct_belle_upcportalreskin_20694_e5816813.jpeg",
                "https://www.peppapig.com/wp-content/uploads/sites/3/2019/02/peppa_pig_splat.png",
                "https://www.pinclipart.com/picdir/big/3-32031_vector-library-stock-chefs-clipart-cooking-demo-chief.png",
                "https://lumiere-a.akamaihd.net/v1/images/ct_belle_upcportalreskin_20694_e5816813.jpeg",
                "https://www.peppapig.com/wp-content/uploads/sites/3/2019/02/peppa_pig_splat.png",
                "https://cdn.dribbble.com/users/1338391/screenshots/15386836/media/dea169824f0cce3899c068c35b82205b.jpg",
                "http://img.over-blog.com/630x470-000000/5/65/87/22//Yamamuro-Tadayoshi-1993/DBZ-ep-173-Yamamuro--5-.png",
        };


        for (int i=0; i<7; i++){
            if(i==0)
                categoriesList.add(
                        new Category("", "U .. Up Special" + (i+1))
                );
            else
                categoriesList.add(
                        new Category("", "Main Category" + (i+1))
                );
        }

        for (int i=0; i<7; i++){
            subCategoriesList.add(
                    new SubCategory("", "Sub Category" + (i+1))
            );
        }

        for (int i=0; i<7; i++){
            storiesList.add(
                    new Story(storiesImages[i], "@_user" + (i+1))
            );
        }

        for (int i=0; i<10; i++){
            productsList.add(
                    new Product(
                            i,
                            "Product Service",
                            "Title Product",
                            10 * (i+1),
                            (i%2 == 0 ) ? 25 : 0,
                            (i%2 == 0 ) ? 4 : 5,
                            (i%2 == 0 ) ? 3 : 4,
                            productsImages[i]
                    )
            );
        }
    }

    public ArrayList<Category> getCategoriesList() {
        return categoriesList;
    }

    public ArrayList<SubCategory> getSubCategoriesList() {
        return subCategoriesList;
    }

    public ArrayList<Story> getStoriesList() {
        return storiesList;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }
}
