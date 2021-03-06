package dev.qinx.faker.utils

import dev.qinx.faker.Faker

import scala.reflect.ClassTag
import scala.util.Random


class SeedTester[T : ClassTag](times: Int = 100) {

  val seed: Long = Random.nextLong()

  val faker: Faker[T] = new Faker[T].setSeed(seed)
  val faker2: Faker[T] = new Faker[T].setSeed(seed)
  val faker3: Faker[T] = new Faker[T]

  (1 to times) foreach { _ =>
    val fd = faker.get()
    val fd2 = faker2.get()
    val fd3 = faker3.get()
    assert(fd.equals(fd2), s"${fd.toString}, ${fd2.toString}")
    assert(!fd.equals(fd3), s"${fd.toString}, ${fd3.toString}")
  }

  def test(f: Faker[T] => Boolean): Unit = {
    (1 to times) foreach { _ =>
      val faker = new Faker[T]().setSeed(Random.nextLong())
      assert(f(faker))
    }
  }

}
