package code.alen.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		var rf = Retrofit.Builder()
			.baseUrl(RetrofitInterface.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create()).build()
		
		var API = rf.create(RetrofitInterface::class.java)
		var Call = API.countries
		
		Call?.enqueue(object:Callback<List<CountriesModel?>?>{
			override fun onResponse(
				call: Call<List<CountriesModel?>?>,
				response: Response<List<CountriesModel?>?>
			) {
				var countrylist : List<CountriesModel>? = response.body() as List<CountriesModel>
				var country = arrayOfNulls<String>(countrylist!!.size)
				var last = arrayOfNulls<String>(countrylist!!.size)
				last[0] = country.last()
				
				for (i in countrylist!!.indices)
					country[i] = countrylist!![i]!!.Country + " / " + countrylist!![i]!!.Slug
				
				var adapter1 = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line, last)
				var textview = findViewById<ListView>(R.id.ListView1)
				textview.adapter = adapter1
				
				var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line, )
				val listview = findViewById<ListView>(R.id.listview)
				
				listview.adapter = adapter
				
					
			}
			
			override fun onFailure(call: Call<List<CountriesModel?>?>, t: Throwable) {
			}
			
		})
	}
	
}