package com.littlegnal.accountingmultiplatform.data

import com.littlegnal.accountingmultiplatform.AccountingDB
import com.squareup.sqldelight.db.SqlDriver

object Db {
  private var driverRef: SqlDriver? = null
  private var dbRef: AccountingDB? = null



  val ready: Boolean
    get() = driverRef != null

  fun dbSetup(driver: SqlDriver) {
    val db = createQueryWrapper(driver)
    driverRef = driver
    dbRef = db
  }

  internal fun dbClear() {
    driverRef?.close()
    dbRef = null
    driverRef = null
  }

  val instance: AccountingDB
    get() = dbRef!!
}