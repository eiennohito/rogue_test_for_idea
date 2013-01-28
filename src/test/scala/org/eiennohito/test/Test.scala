package org.eiennohito.test

import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import net.liftweb.mongodb.record.field.LongPk
import com.foursquare.rogue.Rogue._
import net.liftweb.mongodb.{DefaultMongoIdentifier, MongoDB}
import com.mongodb.Mongo
import net.liftweb.record.field.{LongField, StringField}
import net.liftweb.http.RequestVar
import com.foursquare.rogue.LiftRogue


/**
 * @author eiennohito
 * @since 21.11.11 
 */

class TestRecord private() extends MongoRecord[TestRecord] with LongPk[TestRecord] {
  def meta = TestRecord

  object field1 extends StringField(this, 50)
  object longField extends LongField(this)
}

object TestRecord extends TestRecord with MongoMetaRecord[TestRecord]


class Test extends org.scalatest.FunSuite with org.scalatest.matchers.ShouldMatchers {

  test("rogue works, but type inference in scala-plugin fails") {
    import LiftRogue._

    val x = TestRecord where (_.field1 eqs "test") fetch()
    val y = TestRecord where (_.longField eqs 5L) fetch()
  }
}
