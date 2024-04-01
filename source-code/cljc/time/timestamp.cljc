
(ns time.timestamp
    #?(:clj  (:import org.joda.time.DateTime org.bson.types.BSONTimestamp))
    #?(:clj  (:require [clj-time.core]
                       [fruits.format.api :as format]
                       [fruits.string.api :as string]
                       [time.convert      :as convert]
                       [time.epoch        :as epoch])
       :cljs (:require [cljs-time.core]
                       [cljs-time.format]
                       [fruits.format.api :as format]
                       [fruits.string.api :as string]
                       [time.convert      :as convert]
                       [time.epoch        :as epoch])))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-object
  ; @description
  ; Returns a DateTime object.
  ;
  ; @param (string)(opt) time-zone
  ;
  ; @usage
  ; (timestamp-object)
  ; =>
  ; #<DateTime 2020-04-20T16:20:00.123Z>
  ;
  ; @usage
  ; (timestamp-object "Europe/Budapest")
  ; =>
  ; #<DateTime 2020-04-20T16:20:00.123+02:00>
  ;
  ; @return (object)
  ([]
   #?(:clj  (clj-time.core/now)
      :cljs (cljs-time.core/now)))

  ([time-zone]
   #?(:clj (let [timestamp (clj-time.core/now)
                 time-zone (clj-time.core/time-zone-for-id time-zone)]
                (clj-time.core/to-time-zone timestamp time-zone)))))

(defn timestamp-string
  ; @description
  ; Returns a timestamp string.
  ;
  ; @param (string)(opt) time-zone
  ;
  ; @usage
  ; (timestamp-string)
  ; =>
  ; "2020-04-20T16:20:00.123Z"
  ;
  ; @usage
  ; (timestamp-string "Europe/Budapest")
  ; =>
  ; "2020-04-20T16:20:00.123+02:00"
  ;
  ; @return (string)
  ([]
   ; In CLJS namespaces, the timestamp format is the same as the format used for converting
   ; Java DateTime objects to strings ("2020-04-20T16:20:00.123Z").
   ; Therefore, in CLJS and CLJ namespaces, the format of timestamp strings is the same.
   #?(:clj  (let [timestamp-object (timestamp-object)]
                 (str timestamp-object))
      :cljs (let [formatter (cljs-time.format/formatter "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                  timestamp (cljs-time.core/now)]
                 (cljs-time.format/unparse formatter timestamp))))

  ([time-zone]
   #?(:clj (let [timestamp-object (timestamp-object time-zone)]
                (str timestamp-object)))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string?
  ; @description
  ; Returns TRUE if the given 'n' value is a timestamp string.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (timestamp-string? "2020-04-20T20:00.123+00:00")
  ; =>
  ; true
  ;
  ; @usage
  ; (timestamp-string? "2020-04-20T16:20:00.123Z")
  ; =>
  ; true
  ;
  ; @usage
  ; (timestamp-string? "2020-04-20T16:20:00.123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (and (string? n)
       (or (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}\+\d{2}:\d{2}" n)
           (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}Z"             n)
           (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}"              n))))

(defn timestamp-object?
  ; @description
  ; Returns TRUE if the given 'n' value is a DateTime object.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (timestamp-object? #<DateTime 2020-04-20T16:20:00.123+02:00>)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  #?(:clj (let [type (type n)]
               (= type org.joda.time.DateTime))))

(defn date-string?
  ; @description
  ; Returns TRUE if the given 'n' value is a date string.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (date-string? "2020-04-20")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (and (string? n)
       (re-matches #"\d{4}[-|.]\d{2}[-|.]\d{2}" n)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->year
  ; @description
  ; Converts the given timestamp string into a year value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->year "2020-04-20T16:20:00.123Z")
  ; =>
  ; "2020"
  ;
  ; @return (string)
  [n]
  (string/keep-range n 0 4))

(defn timestamp-object->year
  ; @description
  ; Converts the given DateTime object into a year value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->year #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 2020
  ;
  ; @return (Y)
  [n]
  #?(:clj  (clj-time.core/year  n)
     :cljs (cljs-time.core/year n)))

(defn timestamp-string->month
  ; @description
  ; Converts the given timestamp string into a month value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->month "2020-04-20T16:20:00.123Z")
  ; =>
  ; "04"
  ;
  ; @return (string)
  [n]
  (string/keep-range n 5 7))

(defn timestamp-object->month
  ; @description
  ; Converts the given DateTime object into a month value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->month #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 4
  ;
  ; @return (M)
  [n]
  #?(:clj  (clj-time.core/month  n)
     :cljs (cljs-time.core/month n)))

(defn timestamp-string->week
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @description
  ; Converts the given timestamp string into a week value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->week "2020-04-20T16:20:00.123Z")
  ; =>
  ; "4"
  ;
  ; @return (string)
  [n])
  ; TODO

(defn timestamp-object->week
  ; @description
  ; Converts the given DateTime object into a week value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->week #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 4
  ;
  ; @return (W)
  [n]
  #?(:clj  (clj-time.core/week-number-of-year  n)
     :cljs (cljs-time.core/week-number-of-year n)))

(defn timestamp-string->day
  ; @description
  ; Converts the given timestamp string into a day value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->day "2020-04-20T16:20:00.123Z")
  ; =>
  ; "20"
  ;
  ; @return (string)
  [n]
  (string/keep-range n 8 10))

(defn timestamp-object->day
  ; @description
  ; Converts the given DateTime object into a day value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->day #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 20
  ;
  ; @return (integer)
  [n]
  #?(:clj  (clj-time.core/day  n)
     :cljs (cljs-time.core/day n)))

(defn timestamp-string->hours
  ; @description
  ; Converts the given timestamp string into an hours value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->hours "2020-04-20T16:20:00.123Z")
  ; =>
  ; "16"
  ;
  ; @return (string)
  [n]
  (string/keep-range n 11 13))

(defn timestamp-object->hours
  ; @description
  ; Converts the given DateTime object into an hours value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->hours #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 16
  ;
  ; @return (h)
  [n]
  #?(:clj  (clj-time.core/hour  n)
     :cljs (cljs-time.core/hour n)))

(defn timestamp-string->minutes
  ; @description
  ; Converts the given timestamp string into a minutes value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->minutes "2020-04-20T16:20:00.123Z")
  ; =>
  ; "20"
  ;
  ; @return (string)
  [n]
  (string/keep-range n 14 16))

(defn timestamp-object->minutes
  ; @description
  ; Converts the given DateTime object into a minutes value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->minutes #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 20
  ;
  ; @return (m)
  [n]
  #?(:clj  (clj-time.core/minute  n)
     :cljs (cljs-time.core/minute n)))

(defn timestamp-string->seconds
  ; @description
  ; Converts the given timestamp string into a seconds value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->seconds "2020-04-20T16:20:00.123Z")
  ; =>
  ; "00"
  ;
  ; @return (string)
  [n]
  (string/keep-range n 17 19))

(defn timestamp-object->seconds
  ; @description
  ; Converts the given DateTime object into a seconds value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->seconds #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 0
  ;
  ; @return (s)
  [n]
  #?(:clj  (clj-time.core/second n)
     :cljs (cljs-time.core/sec   n)))

(defn timestamp-string->milliseconds
  ; @description
  ; Converts the given timestamp string into a milliseconds value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->milliseconds "2020-04-20T16:20:00.123Z")
  ; =>
  ; "123"
  ;
  ; @return (string)
  [n]
  (string/keep-range n 20 23))

(defn timestamp-object->milliseconds
  ; @description
  ; Converts the given DateTime object into a milliseconds value.
  ;
  ; @param (object) n
  ;
  ; @usage
  ; (timestamp-object->milliseconds #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 123
  ;
  ; @return (ms)
  [n]
  #?(:clj  (clj-time.core/milli  n)
     :cljs (cljs-time.core/milli n)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->today?
  ; @description
  ; Returns TRUE if the given timestamp string corresponds to the actual day.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->today "2020-04-20T16:20:00.123Z")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [x (timestamp-string)]
       (= (string/keep-range n 0 10)
          (string/keep-range x 0 10))))

(defn timestamp-string->date
  ; @description
  ; Converts the given timestamp string into formatted date string.
  ;
  ; @param (string) n
  ; @param (keyword)(opt) format
  ; :mmdd, :yymmdd, :yyyymmdd
  ; Default: :yyyymmdd
  ;
  ; @usage
  ; (timestamp-string->date "2020-04-20T16:20:00.123Z" :yyyymmdd)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->date n :yyyymmdd))

  ([n format]
   (if (string/not-empty? n)
       (let [year                             (timestamp-string->year  n)
             month (format/fill-leading-zeros (timestamp-string->month n) 2)
             day   (format/fill-leading-zeros (timestamp-string->day   n) 2)]
            (case format :yyyymmdd (str year"-"month"-"day)
                         :yymmdd   (let [year (string/keep-range year 2 4)]
                                        (str year"-"month"-"day))
                         :mmdd     (str month"-"day)
                         (-> n))))))

(defn timestamp-string->time
  ; @description
  ; Converts the given timestamp string into formatted time string.
  ;
  ; @param (string) n
  ; @param (keyword)(opt) format
  ; :hhmm, :hhmmss, :hhmmssmmm
  ; Default: :hhmmss
  ;
  ; @usage
  ; (timestamp-string->time "2020-04-20T16:20:00.123Z" :hhmmss)
  ; =>
  ; "16:20:00"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->time n :hhmmss))

  ([n format]
   (if (string/not-empty? n)
       (let [hours        (format/fill-leading-zeros (timestamp-string->hours        n) 2)
             minutes      (format/fill-leading-zeros (timestamp-string->minutes      n) 2)
             seconds      (format/fill-leading-zeros (timestamp-string->seconds      n) 2)
             milliseconds (format/fill-leading-zeros (timestamp-string->milliseconds n) 3)]
            (case format :hhmmssmmm (str hours":"minutes":"seconds"."milliseconds)
                         :hhmmss    (str hours":"minutes":"seconds)
                         :hhmm      (str hours":"minutes)
                         (-> n))))))

(defn timestamp-string->date-time
  ; @description
  ; Converts the given timestamp string into formatted date and time string.
  ;
  ; @param (string) n
  ; @param (keyword)(opt) date-format
  ; :mmdd, :yymmdd, :yyyymmdd
  ; Default: :yyyymmdd
  ; @param (keyword)(opt) time-format
  ; :hhmm, :hhmmss, :hhmmssmmm
  ; Default: :hhmmss
  ;
  ; @usage
  ; (timestamp-string->date-time "2020-04-20T16:20:00.123Z" :yyyymmdd :hhmmss)
  ; =>
  ; "2020-04-20 - 16:20:00"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->date-time n :yyyymmdd :hhmmss))

  ([n time-format]
   (timestamp-string->date-time n :yyyymmdd time-format))

  ([n date-format time-format]
   (if (string/not-empty? n)
       (let [date (timestamp-string->date n date-format)
             time (timestamp-string->time n time-format)]
            (str date" - "time)))))

(defn timestamp-string->actual-timestamp
  ; @description
  ; Returns a formatted timestamp as a string, either "Today, HH:MM" if the input
  ; timestamp corresponds to the current day, or "YYYY/MM/DD" if it's a different day.
  ;
  ; @param (string) timestamp
  ; @param (string) today
  ; Default: "Today"
  ;
  ; @usage
  ; (timestamp-string->actual-timestamp "2020-04-20T16:20:00.123Z" "Today")
  ; =>
  ; "Today, 16:20"
  ;
  ; @usage
  ; (timestamp-string->actual-timestamp "2020-04-20T16:20:00.123Z" "Today")
  ; =>
  ; "2020/04/20"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->actual-timestamp n "Today"))

  ([n today]
   (if (timestamp-string->today? n)
       (let [time (timestamp-string->time n :hhmm)]
            (str today ", " time))
       (timestamp-string->date n :yyyymmdd))))

(defn timestamp-string->elapsed-time
  ; @description
  ; Returns the elapsed time in a user-friendly format based on the given timestamp string.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->elapsed-time "2020-04-20T16:20:00.123Z")
  ; =>
  ; "5m"
  ;
  ; @usage
  ; (timestamp-string->elapsed-time "2020-04-20T16:20:00.123Z")
  ; =>
  ; "7d"
  ;
  ; @return (string)
  [n])
  ; TODO

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->elapsed-ms
  ; @description
  ; Returns how many milliseconds elapsed since the given timestamp string.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->elapsed-ms "2020-04-20T16:20:00.123Z")
  ;
  ; @return (ms)
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-string->epoch-ms (- epoch-ms))))

(defn timestamp-object->elapsed-ms
  ; @description
  ; Returns how many milliseconds elapsed since the given DateTime object.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-object->elapsed-ms #<DateTime 2020-04-20T16:20:00.123Z>)
  ;
  ; @return (ms)
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-object->epoch-ms (- epoch-ms))))

(defn timestamp-string->elapsed-s
  ; @description
  ; Returns how many seconds elapsed since the given timestamp string.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->elapsed-s "2020-04-20T16:20:00.123Z")
  ;
  ; @return (s)
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-string->epoch-ms (- epoch-ms) convert/ms->s)))

(defn timestamp-object->elapsed-s
  ; @description
  ; Returns how many seconds elapsed since the given DateTime object.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-object->elapsed-s #<DateTime 2020-04-20T16:20:00.123Z>)
  ;
  ; @return (s)
  [n]
  (let [epoch-ms (epoch/epoch-ms)]
       (->> n epoch/timestamp-object->epoch-ms (- epoch-ms) convert/ms->s)))
