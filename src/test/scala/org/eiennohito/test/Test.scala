package org.eiennohito.test

import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import net.liftweb.mongodb.record.field.LongPk
import net.liftweb.record.field.StringField
import com.foursquare.rogue.Rogue._
import net.liftweb.mongodb.{DefaultMongoIdentifier, MongoDB}
import com.mongodb.Mongo


/**
 * @author eiennohito
 * @since 21.11.11 
 */

class TestRecord private() extends MongoRecord[TestRecord] with LongPk[TestRecord] {
  def meta = TestRecord

  object field1 extends StringField(this, 50)
}

object TestRecord extends TestRecord with MongoMetaRecord[TestRecord]

class Test extends org.scalatest.FunSuite with org.scalatest.matchers.ShouldMatchers {
  test("rogue works, but type inference in scala-plugin fails") {
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo, "test")

    val v = TestRecord.createRecord.field1("smt").save

    val rec = TestRecord where (_.field1 eqs "smt") get()
    rec should not be None
    rec.get.id.is should equal (v.id.is)
  }
}