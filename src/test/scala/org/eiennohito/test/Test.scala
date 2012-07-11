package org.eiennohito.test

import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import net.liftweb.mongodb.record.field.LongPk
import com.foursquare.rogue.Rogue._
import net.liftweb.mongodb.{DefaultMongoIdentifier, MongoDB}
import com.mongodb.Mongo
import net.liftweb.record.field.{LongField, StringField}
import net.liftweb.http.RequestVar


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

object ReqVal extends RequestVar[String]("asdf")
//Red code for ReqVal
//Object creation impossible since member set(in: Settable.this.type#ValueType): Settable.this.type#ValueType in net.liftweb.util.Settable is not defined

class Test extends org.scalatest.FunSuite with org.scalatest.matchers.ShouldMatchers {
  test("rogue works, but type inference in scala-plugin fails") {
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo, "test")

    val v = TestRecord.createRecord.field1("smt")
    //Red code for field1.apply param
    //Type mismatch, expected Box[field1.MyType], actual: String
    //Type mismatch, expected field1.MyType, actual: String
  }
}
