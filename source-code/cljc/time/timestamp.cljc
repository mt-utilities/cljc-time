
(ns time.timestamp
    #?(:clj (:import org.joda.time.DateTime org.bson.types.BSONTimestamp))
    (:require #?(:clj  [clj-time.core])
              #?(:cljs [cljs-time.core])
              #?(:cljs [cljs-time.format])
              [format.api   :as format]
              [string.api   :as string]
              [time.convert :as convert]
              [time.epoch   :as epoch]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-object
  ; @description
  ; Returns a timestamp object.
  ;
  ; @param (string)(opt) time-zone
  ;
  ; @example
  ; (timestamp-object)
  ; =>
  ; #<DateTime 2020-04-20T16:20:00.123Z>
  ;
  ; @example
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
  ; @example
  ; (timestamp-string)
  ; =>
  ; "2020-04-20T16:20:00.123Z"
  ;
  ; @example
  ; (timestamp-string "Europe/Budapest")
  ; =>
  ; "2020-04-20T16:20:00.123+02:00"
  ;
  ; @return (string)
  ([]
   ; In CLJS namespaces, the timestamp format is the same as the format used for converting
   ; Java timestamp objects to strings ("2020-04-20T16:20:00.123Z").
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
  ; @example
  ; (timestamp-string? "2020-04-20T20:00.123+00:00")
  ; =>
  ; true
  ;
  ; @example
  ; (timestamp-string? "2020-04-20T16:20:00.123Z")
  ; =>
  ; true
  ;
  ; @example
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
  ; Returns TRUE if the given 'n' value is a timestamp object.
  ;
  ; @param (*) n
  ;
  ; @example
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
  ; @example
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
  ; Converts the given timestamp string to year.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->year "2020-04-20T16:20:00.123Z")
  ; =>
  ; "2020"
  ;
  ; @return (string)
  [n]
  (string/part n 0 4))

(defn timestamp-object->year
  ; @description
  ; Converts the given timestamp object to year.
  ;
  ; @param (object) n
  ;
  ; @example
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
  ; Converts the given timestamp string to month.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->month "2020-04-20T16:20:00.123Z")
  ; =>
  ; "04"
  ;
  ; @return (string)
  [n]
  (string/part n 5 7))

(defn timestamp-object->month
  ; @description
  ; Converts the given timestamp object to month.
  ;
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->month #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 4
  ;
  ; @return (M)
  [n]
  #?(:clj  (clj-time.core/month  n)
     :cljs (cljs-time.core/month n)))

(defn timestamp-string->week
  ; @description
  ; Converts the given timestamp string to week.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->week "2020-04-20T16:20:00.123Z")
  ; =>
  ; "4"
  ;
  ; @return (string)
  [n])
  ; TODO

(defn timestamp-object->week
  ; @description
  ; Converts the given timestamp object to week.
  ;
  ; @param (object) n
  ;
  ; @example
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
  ; Converts the given timestamp string to day.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->day "2020-04-20T16:20:00.123Z")
  ; =>
  ; "20"
  ;
  ; @return (string)
  [n]
  (string/part n 8 10))

(defn timestamp-object->day
  ; @description
  ; Converts the given timestamp object to day.
  ;
  ; @param (object) n
  ;
  ; @example
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
  ; Converts the given timestamp string to hours.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->hours "2020-04-20T16:20:00.123Z")
  ; =>
  ; "16"
  ;
  ; @return (string)
  [n]
  (string/part n 11 13))

(defn timestamp-object->hours
  ; @description
  ; Converts the given timestamp object to hours.
  ;
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->hours #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 16
  ;
  ; @return (h)
  [n]
  #?(:clj  (clj-time.core/hours n)
     :cljs (cljs-time.core/hour n)))

(defn timestamp-string->minutes
  ; @description
  ; Converts the given timestamp string to minutes.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->minutes "2020-04-20T16:20:00.123Z")
  ; =>
  ; "20"
  ;
  ; @return (string)
  [n]
  (string/part n 14 16))

(defn timestamp-object->minutes
  ; @description
  ; Converts the given timestamp object to minutes.
  ;
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->minutes #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 20
  ;
  ; @return (m)
  [n]
  #?(:clj  (clj-time.core/minutes n)
     :cljs (cljs-time.core/minute n)))

(defn timestamp-string->seconds
  ; @description
  ; Converts the given timestamp string to seconds.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->seconds "2020-04-20T16:20:00.123Z")
  ; =>
  ; "00"
  ;
  ; @return (string)
  [n]
  (string/part n 17 19))

(defn timestamp-object->seconds
  ; @description
  ; Converts the given timestamp object to seconds.
  ;
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->seconds #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 0
  ;
  ; @return (s)
  [n]
  #?(:clj  (clj-time.core/seconds n)
     :cljs (cljs-time.core/sec    n)))

(defn timestamp-string->milliseconds
  ; @description
  ; Converts the given timestamp string to milliseconds.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->milliseconds "2020-04-20T16:20:00.123Z")
  ; =>
  ; "123"
  ;
  ; @return (string)
  [n]
  (string/part n 20 23))

(defn timestamp-object->milliseconds
  ; @description
  ; Converts the given timestamp object to milliseconds.
  ;
  ; @param (object) n
  ;
  ; @example
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

(defn timestamp-string->date
  ; @description
  ; Converts the given timestamp string to date string.
  ;
  ; @param (string) n
  ; @param (keyword)(opt) format
  ; :mmdd, :yymmdd, :yyyymmdd
  ; Default: :yyyymmdd
  ;
  ; @example
  ; (timestamp-string->date "2020-04-20T16:20:00.123Z" :yyyymmdd)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->date n :yyyymmdd))

  ([n format]
   (if (string/nonblank? n)
       (let [year                        (timestamp-string->year  n)
             month (format/leading-zeros (timestamp-string->month n) 2)
             day   (format/leading-zeros (timestamp-string->day   n) 2)]
            (case format :yyyymmdd (str year"-"month"-"day)
                         :yymmdd   (let [year (string/part year 2 4)]
                                        (str year"-"month"-"day))
                         :mmdd     (str month"-"day)
                         (-> n))))))

(defn timestamp-string->time
  ; @description
  ; Converts the given timestamp string to time string.
  ;
  ; @param (string) n
  ; @param (keyword)(opt) format
  ; :hhmm, :hhmmss, :hhmmssmmm
  ; Default: :hhmmss
  ;
  ; @example
  ; (timestamp-string->time "2020-04-20T16:20:00.123Z" :hhmmss)
  ; =>
  ; "16:20:00"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->time n :hhmmss))

  ([n format]
   (if (string/nonblank? n)
       (let [hours        (format/leading-zeros (timestamp-string->hours        n) 2)
             minutes      (format/leading-zeros (timestamp-string->minutes      n) 2)
             seconds      (format/leading-zeros (timestamp-string->seconds      n) 2)
             milliseconds (format/leading-zeros (timestamp-string->milliseconds n) 3)]
            (case format :hhmmssmmm (str hours":"minutes":"seconds"."milliseconds)
                         :hhmmss    (str hours":"minutes":"seconds)
                         :hhmm      (str hours":"minutes)
                         (-> n))))))

(defn timestamp-string->date-time
  ; @description
  ; Converts the given timestamp string to date and time string.
  ;
  ; @param (string) n
  ; @param (keyword)(opt) date-format
  ; :mmdd, :yymmdd, :yyyymmdd
  ; Default: :yyyymmdd
  ; @param (keyword)(opt) time-format
  ; :hhmm, :hhmmss, :hhmmssmmm
  ; Default: :hhmmss
  ;
  ; @example
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
   (if (string/nonblank? n)
       (let [date (timestamp-string->date n date-format)
             time (timestamp-string->time n time-format)]
            (str date" - "time)))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->today?
  ; @description
  ; Returns TRUE if the given timestamp string corresponds to the actual day.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->today "2020-04-20T16:20:00.123Z")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [x (timestamp-string)]
       (= (string/part n 0 10)
          (string/part x 0 10))))

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
  ; Returns how many milliseconds elapsed since the given timestamp object.
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
  ; Returns how many seconds elapsed since the given timestamp object.
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
