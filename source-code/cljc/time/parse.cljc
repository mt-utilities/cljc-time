
(ns time.parse
    (:require #?(:clj [clj-time.format])
              [map.api        :as map]
              [time.timestamp :as timestamp]
              [vector.api     :as vector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn parse-date
  ; @description
  ; Converts the given date string into a timestamp object.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (parse-date "2020-04-20")
  ; =>
  ; #<DateTime 2020-04-20T00:00:00.000Z>
  ;
  ; @return (object)
  [n]
  #?(:clj (try (let [formatter (clj-time.format/formatter "yyyy-MM-dd")]
                    (clj-time.format/parse formatter n))
               (catch Exception e (println e)))))

(defn parse-timestamp
  ; @description
  ; Converts the given timestamp string into a timestamp object.
  ;
  ; @param (string) n
  ;
  ; @example
  ; (parse-timestamp "2020-04-20T16:20:00.123")
  ; =>
  ; #<DateTime 2020-04-20T16:20:00.123Z>
  ;
  ; @return (object)
  [n]
  #?(:clj (try (let [formatter (clj-time.format/formatters :date-time)]
                    (clj-time.format/parse formatter n))
               (catch Exception e (println e)))))

(defn unparse-timestamp
  ; @description
  ; Converts the given timestamp object into a timestamp string.
  ;
  ; @param (object) n
  ;
  ; @example
  ; (unparse-timestamp #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; "2020-04-20T16:20:00.123"
  ;
  ; @return (string)
  [n]
  #?(:clj (str n)))

;; -- Parse / unparse date and time in data structures ------------------------
;; ----------------------------------------------------------------------------

(defn parse-timestamps
  ; @description
  ; Converts the timestamp strings in the given data structure into timestamp objects.
  ;
  ; @param (*) n
  ;
  ; @example
  ; (parse-timestamps {:my-timestamp "2020-04-20T16:20:00.123Z"})
  ; =>
  ; {:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>}
  ;
  ; @return (*)
  [n]
  (cond (timestamp/date-string?      n) (parse-date      n)
        (timestamp/timestamp-string? n) (parse-timestamp n)
        (map?                        n) (map/->values    n parse-timestamps)
        (vector?                     n) (vector/->items  n parse-timestamps)
        :return n))

(defn unparse-timestamps
  ; @description
  ; Converts the timestamp objects in the given data structure into timestamp strings.
  ;
  ; @param (*) n
  ;
  ; @example
  ; (unparse-timestamps {:my-timestamp #<DateTime 2020-04-20T16:20:00.123Z>})
  ; =>
  ; {:my-timestamp "2020-04-20T16:20:00.123Z"}
  ;
  ; @return (*)
  [n]
  (cond (timestamp/timestamp-object? n) (unparse-timestamp n)
        (map?                        n) (map/->values      n unparse-timestamps)
        (vector?                     n) (vector/->items    n unparse-timestamps)
        :return n))
