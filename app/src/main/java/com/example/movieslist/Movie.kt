import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Movie(
    val title: String,
    val description: String,
    val imageUrl: String,
    val instructionUrl: String) {

    companion object {

        fun getMoviesFromFile(filename: String, context: Context): ArrayList<Movie> {
            val movieList = ArrayList<Movie>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset("movies.json", context)
                val json = JSONObject(jsonString)
                val movies = json.getJSONArray("movies")

                // Get Movie objects from data
                (0 until movies.length()).mapTo(movieList) {
                    Movie(movies.getJSONObject(it).getString("title"),
                        movies.getJSONObject(it).getString("description"),
                        movies.getJSONObject(it).getString("image"),
                        movies.getJSONObject(it).getString("url"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return movieList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}