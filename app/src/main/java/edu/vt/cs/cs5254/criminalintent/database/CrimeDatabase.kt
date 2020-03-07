package edu.vt.cs.cs5254.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import edu.vt.cs.cs5254.criminalintent.Crime
import java.util.*

@Database(entities = [ Crime::class ], version=1)
@TypeConverters(CrimeDatabase.CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase() {

    abstract fun crimeDao(): CrimeDao

    class CrimeTypeConverters {

        @TypeConverter
        fun fromDate(date: Date?): Long? {
            return date?.time
        }

        @TypeConverter
        fun toDate(millisSinceEpoch: Long?): Date? {
            return millisSinceEpoch?.let {
                Date(it)
            }
        }

        @TypeConverter
        fun toUUID(uuid: String?): UUID? {
            return UUID.fromString(uuid)
        }

        @TypeConverter
        fun fromUUID(uuid: UUID?): String? {
            return uuid?.toString()
        }
    }


}