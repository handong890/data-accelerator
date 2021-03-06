// *********************************************************************
// Copyright (c) Microsoft Corporation.  All rights reserved.
// Licensed under the MIT License
// *********************************************************************
package datax.test.sink

import datax.client.redis.{RedisBase, RedisServerConf}
import org.scalatest.{FlatSpec, Matchers}

class RedisTests extends FlatSpec with Matchers{
  org.apache.log4j.BasicConfigurator.configure()

  "RedisBase" should "parse connection string correctly" in {
    val connectionString = "asdfasdf.asdfasd.com:6380,password=insertpasswordhere=,ssl=True,abortConnect=False"

    RedisBase.parseConnectionString(connectionString) shouldBe RedisServerConf(
      name =  "asdfasdf.asdfasd.com",
      host = "asdfasdf.asdfasd.com",
      port = 6380,
      key = "insertpasswordhere=",
      timeout = 3000,
      isCluster = true,
      useSsl = true
    )
  }
}
