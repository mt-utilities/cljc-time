
(ns time.epoch
    (:require [clj-time.coerce  :as clj-time.coerce]
              [clj-time.core    :as clj-time.core]
              [iso.time.convert :as convert]
              [string.api       :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms
  ; @usage
  ; (epoch-ms)
  ;
  ; @return (ms)
  []
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)))

(defn epoch-s
  ; @usage
  ; (epoch-s)
  ;
  ; @return (s)
  []
  (-> (clj-time.core/now)
      (clj-time.coerce/to-long)
      (quot 1000)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms->timestamp-string
  ; @param (ms) n
  ;
  ; @example
  ; (epoch-ms->timestamp-string 1640800860000)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n]
  (if n (-> n clj-time.coerce/from-long str)))

(defn epoch-s->timestamp-string
  ; @param (s) n
  ;
  ; @example
  ; (epoch-s->timestamp-string 1640800860)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n]
  (if n (-> n convert/s->ms clj-time.coerce/from-long str)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->epoch-ms
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->epoch-ms "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860000
  ;
  ; @return (ms)
  [n]
  (if n (-> n clj-time.coerce/to-epoch convert/s->ms)))

(defn timestamp-string->epoch-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->epoch-s "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n]
  (if n (-> n clj-time.coerce/to-epoch)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-object->epoch-ms
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-object->epoch-ms #<DateTime 2021-12-29T18:01:00.000+02:00>)
  ; =>
  ; 1640800860000
  ;
  ; @return (ms)
  [n]
  (if n (-> n str clj-time.coerce/to-epoch convert/s->ms)))

(defn timestamp-object->epoch-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-object->epoch-s #<DateTime 2021-12-29T18:01:00.000+02:00>)
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n]
  (if n (-> n str clj-time.coerce/to-epoch)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn date->epoch-ms
  ; @description
  ; Converts the given date to timestamp-string than converts the result to epoch-ms.
  ;
  ; @param (string) date
  ;
  ; @usage
  ; (date->epoch-ms "2020-04-20")
  ;
  ; @example
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
  ; Converts the given epoch-ms to timestamp-string than converts the result to date.
  ;
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (epoch-ms->date 1587340800000)
  ;
  ; @example
  ; (epoch-ms->date 1587340800000)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  ; The date that contains the given epoch-ms.
  [epoch-ms]
  (-> epoch-ms epoch-ms->timestamp-string (string/part 0 10)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn date-contains-epoch-ms?
  ; @description
  ; Returns true if the given epoch-ms is ...
  ; ... >= the first ms of the given date, and
  ; ... <= the last ms of the given date.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-contains-epoch-ms? "2020-04-20" 1587344200000)
  ;
  ; @example
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
  ; Returns true if the given epoch-ms is ...
  ; ... >= the first ms of the given date.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-starts-before-epoch-ms? "2020-04-20" 1587344200000)
  ;
  ; @example
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
  ; Returns true if the given epoch-ms is ...
  ; ... < the first ms of the given date.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-starts-after-epoch-ms? "2020-04-21" 1587344200000)
  ;
  ; @example
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
  ; Returns true if the given epoch-ms is ...
  ; ... > the last ms of the given date.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-ends-before-epoch-ms? "2020-04-19" 1587344200000)
  ;
  ; @example
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
  ; Returns true if the given epoch-ms is ...
  ; ... <= the last ms of the given date.
  ;
  ; @param (string) date
  ; @param (ms) epoch-ms
  ;
  ; @usage
  ; (date-ends-after-epoch-ms? "2020-04-20" 1587344200000)
  ;
  ; @example
  ; (date-ends-after-epoch-ms? "2020-04-20" 1587344200000)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [date epoch-ms]
  (let [date-start-ms (date->epoch-ms date)
        date-end-ms   (+ date-start-ms 86399999)]
       (<= epoch-ms date-end-ms)))
