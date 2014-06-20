package nl.viking.model.internal

import com.google.code.morphia.annotations.Entity
import com.google.code.morphia.annotations.Indexed
import com.google.code.morphia.query.Query
import nl.viking.db.MorphiaFactory
import nl.viking.model.morphia.Model
import org.hibernate.criterion.Restrictions


/**
 * User: mardo
 * Date: 12/4/13
 * Time: 3:00 PM
 */

@Entity
class VikingMessageEntry extends Model {

	@Indexed
	String key

	@Indexed
	String locale

	String value

	def saveValue() {
		def entryInDB = get(key, locale) ?: this
		entryInDB.value = this.value
		entryInDB.save()
	}

	static VikingMessageEntry get(String key, String locale) {
		if (!MorphiaFactory.hasMongo()) {
			return null
		}

		try {
			return VikingMessageEntry.find("key,locale",key,locale).get()
		} catch (e) {
			return null
		}
	}

}