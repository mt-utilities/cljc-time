
(ns time.api
    (:require [iso.time.convert :as convert]
              [time.core        :as core]
              [time.current     :as current]
              [time.epoch       :as epoch]
              [time.loop        :as loop]
              [time.now         :as now]
              [time.parse       :as parse]
              [time.schedule    :as schedule]
              [time.timestamp   :as timestamp]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; iso.time.convert
(def ms->s    convert/ms->s)
(def ms->m    convert/ms->m)
(def ms->h    convert/ms->h)
(def ms->D    convert/ms->D)
(def ms->W    convert/ms->W)
(def s->ms    convert/s->ms)
(def s->m     convert/s->m)
(def s->h     convert/s->h)
(def s->D     convert/s->D)
(def s->W     convert/s->W)
(def m->ms    convert/m->ms)
(def m->s     convert/m->s)
(def m->h     convert/m->h)
(def m->D     convert/m->D)
(def m->W     convert/m->W)
(def h->ms    convert/h->ms)
(def h->s     convert/h->s)
(def h->m     convert/h->m)
(def h->D     convert/h->D)
(def h->W     convert/h->W)
(def ms->time convert/ms->time)

; time.core
(def days  core/days)
(def minus core/minus)
(def plus  core/plus)

; time.current
(def get-year                               current/get-year)
(def get-month                              current/get-month)
(def get-day                                current/get-day)
(def get-date                               current/get-date)
(def get-hours                              current/get-hours)
(def get-hours-left-from-this-day           current/get-hours-left-from-this-day)
(def get-minutes                            current/get-minutes)
(def get-minutes-left-from-this-hour        current/get-minutes-left-from-this-hour)
(def get-seconds                            current/get-seconds)
(def get-seconds-left-from-this-minute      current/get-seconds-left-from-this-minute)
(def get-milliseconds                       current/get-milliseconds)
(def get-milliseconds-left-from-this-second current/get-milliseconds-left-from-this-second)
(def get-milliseconds-left-from-this-minute current/get-milliseconds-left-from-this-minute)

; time.epoch
(def epoch-ms                     epoch/epoch-ms)
(def epoch-s                      epoch/epoch-s)
(def epoch-ms->timestamp-string   epoch/epoch-ms->timestamp-string)
(def epoch-s->timestamp-string    epoch/epoch-s->timestamp-string)
(def timestamp-string->epoch-ms   epoch/timestamp-string->epoch-ms)
(def timestamp-string->epoch-s    epoch/timestamp-string->epoch-s)
(def timestamp-object->epoch-ms   epoch/timestamp-object->epoch-ms)
(def timestamp-object->epoch-s    epoch/timestamp-object->epoch-s)
(def date->epoch-ms               epoch/date->epoch-ms)
(def epoch-ms->date               epoch/epoch-ms->date)
(def date-contains-epoch-ms?      epoch/date-contains-epoch-ms?)
(def date-starts-before-epoch-ms? epoch/date-starts-before-epoch-ms?)
(def date-starts-after-epoch-ms?  epoch/date-starts-after-epoch-ms?)
(def date-ends-before-epoch-ms?   epoch/date-ends-before-epoch-ms?)
(def date-ends-after-epoch-ms?    epoch/date-ends-after-epoch-ms?)

; time.loop
(def reduce-interval loop/reduce-interval)

; time.now
(def elapsed now/elapsed)

; time.parse
(def parse-date        parse/parse-date)
(def parse-timestamp   parse/parse-timestamp)
(def unparse-timestamp parse/unparse-timestamp)
(def parse-date-time   parse/parse-date-time)
(def unparse-date-time parse/unparse-date-time)

; time.schedule
(def set-timeout!    schedule/set-timeout!)
(def set-interval!   schedule/set-interval!)
(def clear-interval! schedule/clear-interval!)

; time.timestamp
(def timestamp-object               timestamp/timestamp-object)
(def timestamp-string               timestamp/timestamp-string)
(def timestamp-string?              timestamp/timestamp-string?)
(def timestamp-object?              timestamp/timestamp-object?)
(def date-string?                   timestamp/date-string?)
(def timestamp-string->year         timestamp/timestamp-string->year)
(def timestamp-object->year         timestamp/timestamp-object->year)
(def timestamp-string->month        timestamp/timestamp-string->month)
(def timestamp-object->month        timestamp/timestamp-object->month)
(def timestamp-string->day          timestamp/timestamp-string->day)
(def timestamp-object->day          timestamp/timestamp-object->day)
(def timestamp-string->hours        timestamp/timestamp-string->hours)
(def timestamp-object->hours        timestamp/timestamp-object->hours)
(def timestamp-string->minutes      timestamp/timestamp-string->minutes)
(def timestamp-object->minutes      timestamp/timestamp-object->minutes)
(def timestamp-string->seconds      timestamp/timestamp-string->seconds)
(def timestamp-object->seconds      timestamp/timestamp-object->seconds)
(def timestamp-string->milliseconds timestamp/timestamp-string->milliseconds)
(def timestamp-object->milliseconds timestamp/timestamp-object->milliseconds)
(def timestamp-string->date         timestamp/timestamp-string->date)
(def timestamp-string->time         timestamp/timestamp-string->time)
(def timestamp-string->date-time    timestamp/timestamp-string->date-time)
(def timestamp-string->today?       timestamp/timestamp-string->today?)
(def timestamp-string->elapsed-ms   timestamp/timestamp-string->elapsed-ms)
(def timestamp-object->elapsed-ms   timestamp/timestamp-object->elapsed-ms)
(def timestamp-string->elapsed-s    timestamp/timestamp-string->elapsed-s)
(def timestamp-object->elapsed-s    timestamp/timestamp-object->elapsed-s)
