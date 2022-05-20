package code.alen.covid

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
	
	@get:GET("countries")
	val countries : Call<List<CountriesModel?>?>?
	
	companion object {
		const val BASE_URL = "https://api.covid19api.com/countries"
	}
}