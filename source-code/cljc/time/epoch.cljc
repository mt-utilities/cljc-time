
(ns time.epoch
    #?(:clj  (:require [clj-time.coerce]
                       [clj-time.core]
                       [fruits.string.api :as string]
                       [time.convert      :as convert])
       :cljs (:require [fruits.string.api :as string]
                       [time.convert      :as convert])))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms
  ; @description
  ; Returns the actual epoch milliseconds.
  ;
  ; @usage
  ; (epoch-ms)
  ;
  ; @return (ms)
  []
  #?(:clj (-> (clj-time.core/now)
              (clj-time.coerce/to-long))))

(defn epoch-s
  ; @description
  ; Returns the actual epoch seconds.
  ;
  ; @usage
  ; (epoch-s)
  ;
  ; @return (s)
  []
  #?(:clj (-> (clj-time.core/now)
              (clj-time.coerce/to-long)
              (quot 1000))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms-age
  ; @description
  ; Returns how many milliseconds elapsed since the given epoch milliseconds value.
  ;
  ; @param (ms) n
  ;
  ; @usage
  ; (epoch-ms-age 1640800860000)
  ; =>
  ; 420000
  ;
  ; @return (ms)
  [n]
  (- (epoch-ms) n))

(defn epoch-s-age
  ; @description
  ; Returns how many seconds elapsed since the given epoch seconds value.
  ;
  ; @param (s) n
  ;
  ; @usage
  ; (epoch-s-age 1640800860)
  ; =>
  ; 420
  ;
  ; @return (s)
  [n]
  (- (epoch-s) n))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms->timestamp-string
  ; @description
  ; Converts the given epoch milliseconds into timestamp string.
  ;
  ; @param (ms) n
  ;
  ; @usage
  ; (epoch-ms->timestamp-string 1640800860000)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n]
  #?(:clj (if n (-> n clj-time.coerce/from-long str))))

(defn epoch-s->timestamp-string
  ; @description
  ; Converts the given epoch seconds into timestamp string.
  ;
  ; @param (s) n
  ;
  ; @usage
  ; (epoch-s->timestamp-string 1640800860)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n]
  #?(:clj (if n (-> n convert/s->ms clj-time.coerce/from-long str))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->epoch-ms
  ; @description
  ; Converts the given timestamp string into epoch milliseconds value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->epoch-ms "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860000
  ;
  ; @return (ms)
  [n]
  #?(:clj (if n (-> n clj-time.coerce/to-epoch convert/s->ms))))

(defn timestamp-string->epoch-s
  ; @description
  ; Converts the given timestamp string into epoch seconds value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-string->epoch-s "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n]
  #?(:clj (if n (-> n clj-time.coerce/to-epoch))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-object->epoch-ms
  ; @description
  ; Converts the given DateTime object into epoch milliseconds value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-object->epoch-ms #<DateTime 2021-12-29T18:01:00.000+02:00>)
  ; =>
  ; 1640800860000
  ;
  ; @return (ms)
  [n]
  #?(:clj (if n (-> n str clj-time.coerce/to-epoch convert/s->ms))))

(defn timestamp-object->epoch-s
  ; @description
  ; Converts the given DateTime object into epoch seconds value.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (timestamp-object->epoch-s #<DateTime 2021-12-29T18:01:00.000+02:00>)
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n]
  #?(:clj (if n (-> n str clj-time.coerce/to-epoch))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn date->epoch-ms
  ; @description
  ; Converts the given date string into epoch milliseconds value.
  ;
  ; @param (string) date
  ;
  ; @usage
  ; (date->epoch-ms "2020-04-20")
  ; =>
  ; 1587340800000
  ;
  ; @return (ms)
  ; The very first millisec of the given date.
  [date]
  (-> date (str "T00:00:00.000Z") timestamp-string->epoch-ms))

(defn epoch-ms->date
  ; @description
  ; Converts the given epoch milliseconds value into date string.
  ;
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (epoch-ms->date 1587340800000)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  ; The date that contains the given epoch-ms.
  [epoch-ms]
  (-> epoch-ms epoch-ms->timestamp-string (string/keep-range 0 10)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn date-contains-epoch-ms?
  ; @description
  ; Returns TRUE if the given epoch milliseconds value is ...
  ; ... >= the first ms of the given date string,
  ; ... <= the last ms of the given date string.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-contains-epoch-ms? "2020-04-20" 1587344200000)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)
        date-end-ms   (+ date-start-ms 86399999)]
       (and (>= epoch-ms date-start-ms)
            (<= epoch-ms date-end-ms))))

(defn date-starts-before-epoch-ms?
  ; @description
  ; Returns TRUE if the given epoch milliseconds value is ...
  ; ... >= the first ms of the given date string.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-starts-before-epoch-ms? "2020-04-20" 1587344200000)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)]
       (>= epoch-ms date-start-ms)))

(defn date-starts-after-epoch-ms?
  ; @description
  ; Returns TRUE if the given epoch milliseconds value is ...
  ; ... < the first ms of the given date string.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-starts-after-epoch-ms? "2020-04-21" 1587344200000)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)]
       (< epoch-ms date-start-ms)))

(defn date-ends-before-epoch-ms?
  ; @description
  ; Returns TRUE if the given epoch milliseconds value is ...
  ; ... > the last ms of the given date string.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-ends-before-epoch-ms? "2020-04-19" 1587344200000)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)
        date-end-ms   (+ date-start-ms 86399999)]
       (> epoch-ms date-end-ms)))

(defn date-ends-after-epoch-ms?
  ; @description
  ; Returns TRUE if the given epoch milliseconds value is ...
  ; ... <= the last ms of the given date string.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-ends-after-epoch-ms? "2020-04-20" 1587344200000)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)
        date-end-ms   (+ date-start-ms 86399999)]
       (<= epoch-ms date-end-ms)))
