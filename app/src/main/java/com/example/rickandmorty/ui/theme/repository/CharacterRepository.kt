import com.example.rickandmorty.ui.theme.dataClass.characters_entity.CharactersEntity

import com.example.rickandmorty.ui.theme.api.API
import com.example.rickandmorty.ui.theme.dataClass.characters_entity.CharacterDetail
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val api: API) {


    suspend fun getCharacterList(): Response<CharactersEntity>? {
        return try {
            val response = api.getCharactersList()
            response
        } catch (e: Exception) {

            e.printStackTrace()
            null
        }
    }


    suspend fun getCharacterDetail(id: String): Response<CharacterDetail>? {
        return try {
            api.getCharacterDetail(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}