//package code.alen.covid;
//
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class CountiesList {
//
//
//    var rf = Retrofit.Builder()
//            .baseUrl(RetrofitInterface.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create()).build()
//
//    var API = rf.create(RetrofitInterface::class.java)
//    var Call = API.countries
//
//    Call?.enqueue(object:Callback<List<CountriesModel?>?>{
//        override fun onResponse(
//                call: Call<List<CountriesModel?>?>,
//        response: Response<List<CountriesModel?>?>
//			) {
//            var countrylist : List<CountriesModel>? = response.body() as List<CountriesModel>
//                    var country = arrayOfNulls<String>(countrylist!!.size)
//
//            for (i in countrylist!!.indices)
//            country[i] = countrylist!![i]!!.Country + " / " + countrylist!![i]!!.Slug
//
//            var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line, country)
//
//            val listview = findViewById<ListView>(R.id.listview)
//
//                    listview.adapter = adapter
//
//
//        }
//
//        override fun onFailure(call: Call<List<CountriesModel?>?>, t: Throwable) {
//        }
//
//    })
//}
